package springBoot.demoSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    @GetMapping("/details")
    public String detailBooking(){
        return  "app/home";
    }
}
