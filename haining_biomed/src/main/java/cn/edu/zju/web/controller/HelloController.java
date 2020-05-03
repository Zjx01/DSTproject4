package cn.edu.zju.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shower on 2017/4/1 0001.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String sayHello(ModelMap modelMap) {
        modelMap.put("msg", "Hello!");
        return "login";
    }
}
