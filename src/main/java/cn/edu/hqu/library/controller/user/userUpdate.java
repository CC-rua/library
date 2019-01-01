package cn.edu.hqu.library.controller.user;

import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("xiugaiyonghu")
public class userUpdate {
    @Autowired
    UserService userService;
    @RequestMapping
    public String ShowUserCheckPage(Model model,String userId){
        User user1 = userService.findUserByUserId(userId);
        model.addAttribute("User", user1);
        return "xiugaiyonghu";
    }
    //改
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void UpDateUser(@RequestBody(required = false) List<User> userList){
        for(User user1:userList){
            String getid=user1.getUserId();
            if(userService.findUserByUserId(getid)!=null){
                userService.addUser(user1);
            }
        }
    }
}
