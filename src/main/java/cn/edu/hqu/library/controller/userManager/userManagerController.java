package cn.edu.hqu.library.controller.userManager;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userManager")
public class userManagerController extends BaseController {
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowUserManagerPage(Model model){
        List<User> AllUsers=userService.findAll();
        model.addAttribute("AllUsers",AllUsers);
        return "userManager";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<User> SearchUser(@RequestBody(required = false) User user1){
        //需要一个User的json
        List<User> result=
        userService.findUserByConditions(user1.getUserId(),user1.getName(),user1.getDepartment(),
                user1.getGrade(),user1.getMajor(),user1.getSex());
        return result;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  String DeleteUser(@RequestBody(required = false) List<String> userId){
        //发回id串
        for(String getid:userId){
            if(userService.findUserByUserId(getid)!=null){
                userService.DeleteByUserId(getid);
            }
        }
        return "userManager";
    }
}
