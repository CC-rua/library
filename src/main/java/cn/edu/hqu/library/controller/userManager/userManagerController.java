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
        String userid = "16251220";
        List<User> result=
        userService.findUserByConditions(userid,null,null,null,null,null);
        return result;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public  String DeleteUser(Model model , @PathVariable("id") String id){
        //发回id串
        String getid=id;
        userService.DeleteByUserId(id);
        return "userManager";
    }
}
