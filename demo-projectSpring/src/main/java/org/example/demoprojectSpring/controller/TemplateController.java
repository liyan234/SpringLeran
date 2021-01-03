package org.example.demoprojectSpring.controller;

import org.example.demoprojectSpring.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("template")
public class TemplateController {

    @Autowired
    private WXConfig config;

    @GetMapping("freemaker")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("setting", config);
        // 不需要加后缀
        // 因为配置文件已经指定了后缀
        return "user/fm/index";
    }

    @GetMapping("thymeleaf")
    public String index2(ModelMap modelMap) {
        modelMap.addAttribute("setting", config);
        // 不需要加后缀
        // 因为配置文件已经指定了后缀
        return "tl/index";
    }

}
