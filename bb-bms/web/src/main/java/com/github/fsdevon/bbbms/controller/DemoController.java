package com.github.fsdevon.bbbms.controller;

import com.github.fsdevon.bbbms.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("demo")
    public String demo(Model model){
        model.addAttribute("message", demoService.getMessage());
        log.info(String.valueOf(demoService.getNumber()));
        return "demo/demo";
    }
}
