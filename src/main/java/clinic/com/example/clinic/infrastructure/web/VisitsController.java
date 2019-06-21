package clinic.com.example.clinic.infrastructure.web;


import clinic.com.example.clinic.domain.DoctorFinder;
import clinic.com.example.clinic.domain.SpecializationFinder;
import clinic.com.example.clinic.domain.VisitFinder;
import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitsController {

    private final VisitFinder visitFinder;
    private final DoctorFinder doctorFinder;
    private final SpecializationFinder specializationFinder;

    @GetMapping("/get/doctor")
    ModelAndView getDoctorsVisits(@RequestParam Long doctorId) {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("DoctorDto",new DoctorDto());
        modelAndView.addObject("visits", visitFinder.findByDoctorId(doctorId));
        modelAndView.addObject("specializations", specializationFinder.findAll());
        return modelAndView;
    }

    @GetMapping("/get/all")
    ModelAndView getAllVisits() {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("visits", visitFinder.findAll());
        modelAndView.addObject("DoctorDto",new DoctorDto());
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("specializations", specializationFinder.findAll());
        return modelAndView;
    }

    @PostMapping("/get/doctor")
    public ModelAndView getDoctorsVisits(@ModelAttribute("DoctorDto") DoctorDto doctorDto ) {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("DoctorDto",new DoctorDto());
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("visits", visitFinder.findByDoctorId(doctorDto.getId()));
        modelAndView.addObject("specializations", specializationFinder.findAll());
        modelAndView.addObject("visits", visitFinder.findByDoctorId(doctorDto.getId()));
        return modelAndView;
    }

}
