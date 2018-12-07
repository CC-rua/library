package cn.edu.hqu.library.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/","index"})
public class indexController {

    @RequestMapping
    public String index()
    {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchBook()
    {

        return "index";
    }


}
