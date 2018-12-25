package cn.edu.hqu.library.controller.advice;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/yijianfankui")
public class adviceController {
    @Autowired
    AdviceRepository adviceRepository;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowAdvicePage(Model model){
        Advice advice = new Advice();
        model.addAttribute("advice",advice);
        return "yijianfankui";
    }
    @RequestMapping(method = RequestMethod.POST,value = "submitAdvice")
    public String  PostAdvice(Advice advice1, Errors errors,Model model) {

        if (advice1 != null) {
            advice1.setState("0");
            adviceRepository.save(advice1);
        }
       advice1 = new Advice();
        model.addAttribute("advice",advice1);
        return "yijianfankui";
    }
}
