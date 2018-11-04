package com.thinkpad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CaculatorController {
    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/caculator", method = RequestMethod.GET, params = "sum")
    public ModelAndView additonal(@RequestParam(name = "numberone") String a, @RequestParam(name = "numbertwo") String b) {

        float numberone = Float.parseFloat(a);
        float numbertwo = Float.parseFloat(b);
        float sum = numberone + numbertwo;

        return new ModelAndView("sum", "sum", sum);
    }

    @RequestMapping(value = "/caculator", method = RequestMethod.GET, params = "sub")
    public ModelAndView sub(@RequestParam(name = "numberone") String a, @RequestParam(name = "numbertwo") String b) {

        float numberone = Float.parseFloat(a);
        float numbertwo = Float.parseFloat(b);
        float sub = numberone - numbertwo;

        return new ModelAndView("sub", "sub", sub);
    }

    @RequestMapping(value = "/caculator", method = RequestMethod.GET, params = "multi")
    public ModelAndView multi(@RequestParam(name = "numberone") String a, @RequestParam(name = "numbertwo") String b) {

        float numberone = Float.parseFloat(a);
        float numbertwo = Float.parseFloat(b);
        float multi = numberone * numbertwo;

        return new ModelAndView("multi", "multi", multi);
    }

    @RequestMapping(value = "/caculator", method = RequestMethod.GET, params = "division")
    public ModelAndView div(@RequestParam(name = "numberone") String a, @RequestParam(name = "numbertwo") String b) throws Exception {

        float numberone = Float.parseFloat(a);
        float numbertwo = Float.parseFloat(b);
        float div = 0;
        try {
            if (numbertwo == 0) {
                throw new Exception("Khong chia duoc cho khong");
            } else
                div = numberone / numbertwo;
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            return new ModelAndView("error", "ms", e.getMessage());
        }
        return new ModelAndView("div", "division", div);
    }
}
