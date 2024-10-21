package com.example.yummy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home(@RequestParam(name="name", required = false, defaultValue = "Seguridad y Calidad en el desarrollo")String)
    model.addAttribute("name",name);
    return "Home";


    @GetMapping("/")
    public String root (@RequestParam(name="name", required = false, defaultValue = "Seguridad y Calidad en el desarrollo")Str)
    model.addAttribute("name",name);
    return "Home";

    
}
