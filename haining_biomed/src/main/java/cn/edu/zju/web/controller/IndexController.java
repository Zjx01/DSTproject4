package cn.edu.zju.web.controller;//package cn.edu.zju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController{
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(path = "/*")
    public String index(){
        log.info("index");
        ModelAndView in=new ModelAndView();
        in.setViewName("index");
        return "index";
    }
}



