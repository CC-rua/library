package cn.edu.hqu.library.controller.user;

import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/xinjianyonghu")
@Controller
public class userAdd {
    private final UserService userService;

    @Autowired
    public userAdd(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String ShowAddUserPage(Model model){
        User user1 = new User();
        model.addAttribute("User",user1);
        return "xinjianyonghu";
    }
    //增
    @RequestMapping(method = RequestMethod.POST)
    public void AddUser(Model model,User user1){
        String getid=user1.getUserId();
        if(userService.findUserByUserId(getid)==null) {
            userService.addUser(user1);
        }
    }
}
