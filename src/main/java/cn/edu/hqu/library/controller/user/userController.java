package cn.edu.hqu.library.controller.user;


import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.Impl.ConvertServiceImpl;
import cn.edu.hqu.library.service.UserService;
import cn.edu.hqu.library.service.dto.users;
import cn.edu.hqu.library.util.DateTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping(value = "/gerenxinxi")
@SessionAttributes({"name","pwd"})
public class userController extends ConvertServiceImpl {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String ShowUserPage(@ModelAttribute("name")String name, Model model){
//
//        User user=  userService.findUserByUserId(name);
//        users users = new users();
//        users.setName(user.getUserId());
//        users.setPwd(user.getPassword());
//        users.setBirthday(user.getBirthday());
//        model.addAttribute(users);
//
//        return "user";
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String showUserInfo(@ModelAttribute("name")String name,Model model)
    {
        User user = userService.findUserByUserId(name);
        user.setPassword("");
        model.addAttribute(user);
        return "gerenxinxi";
    }

}
