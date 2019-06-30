package clinic.com.example.clinic.infrastructure.web;

import clinic.com.example.clinic.domain.VisitFinder;
import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(VisitsController.class)
public class VisitsControllerTest {


    private static final Long TEST_VISIT_ID = 1L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitFinder visits;


    @Before
    public void init() {
        given(this.visits.findById(TEST_VISIT_ID)).willReturn(new VisitDto());
    }

    @Test
    public void testInitNewVisitForm() throws Exception {
        mockMvc.perform(get("/visits/create", TEST_VISIT_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("createVisit"));
    }

    @Test
    public void testProcessNewVisitFormSuccess() throws Exception {


        mockMvc.perform(post("/visits/create", TEST_VISIT_ID)
                .param("doctors",  "George")
                .param("patients", "George")
                .param("visitStatuses", "George")

        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"));
    }

    @Test
    public void testProcessNewVisitFormHasErrors() throws Exception {
        mockMvc.perform(post("/owners/*/pets/{petId}/visits/new", TEST_VISIT_ID)
                .param("name", "George")
        )
                .andExpect(model().attributeHasErrors("visit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

}