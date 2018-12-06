package cn.edu.hqu.library.Example.controller;

import cn.edu.hqu.library.Example.entity.Example;
import cn.edu.hqu.library.Example.entity.TStudent;
import cn.edu.hqu.library.Example.mapper.ExampleImp;
import cn.edu.hqu.library.Example.repository.TStudentRepository;
import cn.edu.hqu.library.Example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExampleController {
    @Autowired
    ExampleImp exampleImp;

    @Autowired
    ExampleService exampleService;

    @Autowired
    TStudentRepository repository;

    @RequestMapping(value = "/")
    public String index(Model model){
        List<Example> examples =  exampleImp.find();
        model.addAttribute("xh",examples.get(0).getXSXH());

        List<TStudent> list = repository.findAll();

        model.addAttribute("students",list);
        return "example";
    }
}
