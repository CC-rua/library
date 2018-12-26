package cn.edu.hqu.library.controller.advice;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chakanfankui")
public class AdviceCheck {
    @Autowired
    AdviceService adviceService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowAdviceCheck(Model model,Integer adviceId){
       // adviceId=8;
        Advice advice = adviceService.findAdviceByAdviceId(adviceId);
        model.addAttribute("Advice",advice);
        return "chakanfankui";
    }
}
