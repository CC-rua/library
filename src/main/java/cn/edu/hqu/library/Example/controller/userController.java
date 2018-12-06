package cn.edu.hqu.library.Example.controller;


import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.service.Impl.ConvertServiceImpl;
import cn.edu.hqu.library.Example.service.UserService;
import cn.edu.hqu.library.Example.service.dto.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping(value = "/user")
@SessionAttributes({"name","pwd"})
public class userController extends ConvertServiceImpl {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ShowUserPage(@ModelAttribute("name")String name, Model model){

        User user=  userService.findUserByUserName(name);
        users users = new users();
        users.setName(user.getUsername());
        users.setPwd(user.getPassword());
        users.setBirthday(user.getBirthday());
        model.addAttribute(users);

        return "user";
    }
}
