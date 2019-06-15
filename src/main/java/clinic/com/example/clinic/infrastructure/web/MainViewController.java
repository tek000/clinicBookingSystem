package clinic.com.example.clinic.infrastructure.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class MainViewController {

    @GetMapping
    ModelAndView mainView() {

        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("today", LocalDateTime.now());
        return mav;
    }
}
