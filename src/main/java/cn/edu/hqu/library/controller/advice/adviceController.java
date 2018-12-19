package cn.edu.hqu.library.controller.advice;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.repository.AdviceRepository;
import cn.edu.hqu.library.service.dto.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/advice")
public class adviceController {
    @Autowired
    AdviceRepository adviceRepository;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowAdvicePage(Model model){
        Advice advice = new Advice();
        model.addAttribute("advice",advice);
        return "advice";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String  PostAdvice(Advice advice1, Errors errors,Model model) {
        if (advice1 != null) {
            adviceRepository.save(advice1);
        }
       advice1 = new Advice();
        model.addAttribute("advice",advice1);
        return "advice";
    }
}
