package cn.edu.hqu.library.Example.controller;

import cn.edu.hqu.library.Example.service.Impl.BaseServiceImpl;
import cn.edu.hqu.library.Example.service.UserService;
import cn.edu.hqu.library.Example.service.dto.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/register")
public class registerController extends BaseServiceImpl {
    private final UserService userService;

    @Autowired
    public registerController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ShowRegisterPage(Model model){
        users user1 = new users();
        model.addAttribute(user1);
        return "register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String RegisterAction(@Valid users user, Errors errors, RedirectAttributes model){
        if(errors.hasErrors()){
            return "register";
        }else{
            users user1 = new users();
            user1.setName(user.getName());
            user1.setPwd(user.getPwd());
            user1.setBirthday(user.getBirthday());
            if(userService.UserRegister(user1)){//注册成功
                return "index";
            }else {
                return "register";
            }
        }
    }
}
