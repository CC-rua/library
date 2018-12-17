package cn.edu.hqu.library.controller.userManagerController;

import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/userManager")
public class userManagerController {
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowUserManagerPage(Model model){
        List<User> AllUsers=userService.findAll();
        model.addAttribute("AllUsers",AllUsers);
        return "userManager";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public  String DeleteUser(Model model , @PathVariable("id") String id){
        //发回id串
        String getid=id;
        userService.DeleteByUserId(id);
        return "userManager";
    }
}
