package clinic.com.example.clinic.infrastructure.web;


import clinic.com.example.clinic.domain.*;
import clinic.com.example.clinic.infrastructure.dto.DoctorDto;
import clinic.com.example.clinic.infrastructure.dto.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitsController {

    private final VisitFinder visitFinder;
    private final DoctorFinder doctorFinder;
    private final PatientFinder patientFinder;
    private final SpecializationFinder specializationFinder;
    private final VisitService visitService;

    @GetMapping("/get/doctor")
    ModelAndView getDoctorsVisits(@RequestParam Long doctorId) {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("VisitDto", new VisitDto());
        modelAndView.addObject("visits", visitFinder.findByDoctorId(doctorId));
        modelAndView.addObject("specializations", specializationFinder.findAll());
        return modelAndView;
    }

    @GetMapping("/get/all")
    ModelAndView getAllVisits() {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("visits", visitFinder.findAll());
        modelAndView.addObject("VisitDto", new VisitDto());
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("specializations", specializationFinder.findAll());
        return modelAndView;
    }

    @PostMapping("/get")
    public ModelAndView getDoctorsVisits(@ModelAttribute("VisitDto") VisitDto visitDto) {
        ModelAndView modelAndView = new ModelAndView("visits.html");
        modelAndView.addObject("VisitDto", new VisitDto());
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("specializations", specializationFinder.findAll());
//        modelAndView.addObject("visits", visitFinder.findByDoctorId(visitDto.getDoctorId()));
//        modelAndView.addObject("visits", visitFinder.findBySpecialization(visitDto.getSpecialization()));
        modelAndView.addObject("visits",
                visitFinder.findByDoctorIdAndSpecialization(visitDto.getDoctorId(), visitDto.getSpecialization()));
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createVisitView() {
        ModelAndView modelAndView = new ModelAndView("createVisit.html");
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("patients", patientFinder.findAll());
        modelAndView.addObject("VisitDto", new VisitDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createVisit(@ModelAttribute VisitDto visitDto) {
        ModelAndView modelAndView = new ModelAndView("createVisit.html");
        modelAndView.addObject("doctors", doctorFinder.findAll());
        modelAndView.addObject("patients", patientFinder.findAll());
        modelAndView.addObject("date", new Date());
        visitDto.setSpecialization(doctorFinder.findById(visitDto.getDoctorId()).getSpecialization());

        visitService.createOrUpdate(visitDto);
        return "redirect:/visits/get/all";
    }


}
