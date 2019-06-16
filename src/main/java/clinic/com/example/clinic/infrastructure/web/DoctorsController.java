package clinic.com.example.clinic.infrastructure.web;


import clinic.com.example.clinic.domain.DoctorFinder;
import clinic.com.example.clinic.domain.DoctorService;
import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorsController {

    private final DoctorFinder doctorFinder;
    private final DoctorService doctorService;

    @GetMapping("/get/{specialization}")
    ModelAndView getDoctors(@PathVariable String specialization) {
        ModelAndView modelAndView = new ModelAndView("doctors.html");
        modelAndView.addObject("specialization", specialization);
        modelAndView.addObject("doctors", doctorFinder.findBySpecialization(specialization));
        return modelAndView;
    }


    @GetMapping("/create")
    ModelAndView createDoctorView() {
        ModelAndView modelAndView = new ModelAndView("createDoctor.html");
        modelAndView.addObject("doctor", new DoctorDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createDoctor(@ModelAttribute DoctorDto doctorDto) {
        doctorService.create(doctorDto);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String deleteDoctor(@RequestParam Long id) {
        doctorService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    ModelAndView editDoctor(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("createDoctor.html");
        modelAndView.addObject("doctor", doctorFinder.findById(id));
        return modelAndView;
    }
}
