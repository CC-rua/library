package cn.edu.hqu.library.Example.controller;

import cn.edu.hqu.library.Example.entity.Borrow;
import cn.edu.hqu.library.Example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/borrow")
@SessionAttributes({"name"})
public class borrowController {
    @Autowired
    BorrowService borrowService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowBorrowPage(@ModelAttribute("name")String name, Model model){
        List<Borrow>borrows;
        borrows= borrowService.borrowInfo(name);
        model.addAttribute("borrows",borrows);
        return "borrow";
    }
}
