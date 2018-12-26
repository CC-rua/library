package cn.edu.hqu.library.controller.user;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import cn.edu.hqu.library.service.dto.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/yonghuguanli")
public class userManagerController extends BaseController {
    private final UserService userService;

    @Autowired
    public userManagerController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String ShowUserManagerPage(Model model){
        List<User> AllUsers=userService.findAll();
        model.addAttribute("AllUsers",AllUsers);
        return "yonghuguanli";
    }

    //删
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  void DeleteUser(@RequestBody(required = false) List<String> userId){
        //发回id串
        for(String getid:userId){
            if(userService.findUserByUserId(getid)!=null){
                userService.DeleteByUserId(getid);
            }
        }
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
    //查
    @RequestMapping(method = RequestMethod.POST)
    public String  SearchUser(Model model,@RequestBody(required = false) User user1) {
        //需要一个User的json
        List<User> list=userService.findUserByConditions(user1.getUserId(), user1.getName(), user1.getDepartment(),user1.getGrade(), user1.getMajor(), user1.getSex());
        model.addAttribute("AllUsers", list);
        return "yonghuguanli::form3";
    }

}
