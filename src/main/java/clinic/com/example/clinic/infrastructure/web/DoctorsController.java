package clinic.com.example.clinic.infrastructure.web;


import clinic.com.example.clinic.domain.DoctorFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorsController {

    private final DoctorFinder doctorFinder;

    @GetMapping("/{specialization}")
    ModelAndView getDoctors(@PathVariable String specialization) {
        ModelAndView modelAndView = new ModelAndView("doctors.html");
        modelAndView.addObject("specialization", specialization);
        modelAndView.addObject("doctors", doctorFinder.findBySpecialization(specialization));
        return modelAndView;
    }


}
