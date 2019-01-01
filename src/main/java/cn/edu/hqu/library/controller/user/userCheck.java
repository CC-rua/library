package cn.edu.hqu.library.controller.user;

import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chakanyonghu")
public class userCheck {
    @Autowired
    UserService userService;
    @RequestMapping
    public String ShowUserCheckPage(Model model,String userId){
        //userId="1625122047";
        User user1 = userService.findUserByUserId(userId);
        model.addAttribute("User", user1);
        return "chakanyonghu";
    }
}
