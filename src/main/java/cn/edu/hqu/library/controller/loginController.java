package cn.edu.hqu.library.controller;

import cn.edu.hqu.library.service.UserService;
import cn.edu.hqu.library.service.dto.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = {"login"})
@SessionAttributes({"name","pwd"})
public class loginController {
    private final UserService userService;

    @Autowired
    public loginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ShowIndexPage(Model model,
                                HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //当用户第二次登陆时，检测这个cookie是否存在
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie2 : cookies) {
            //如果存在这个cookie进行页面跳转
            if (cookie2.getName().equals("user")) {
                if (session.getAttribute("user") != null) {
                    return "redirect:/user";
                } else {
                    users user1 = new users();
                    model.addAttribute(user1);
                    return "login";
                }
            }
        }
        users user1 = new users();
        model.addAttribute(user1);
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String LoginAction(@Valid users user, Errors errors, RedirectAttributes model,
                              HttpServletRequest request, HttpServletResponse response) {
        if(errors.hasErrors()){
            return "login";
        }else{

            Cookie cookie = new Cookie("user",user.getName());
            cookie.setMaxAge(60);//60s
            cookie.setPath("/");//可在同一应用服务器内共享方法
            response.addCookie(cookie);//放到客户端
            //凭这个Cookie就自动登录并不安全可以在服务端使用一个Session来管理用户。
            //当第一次登录成功后，就创建一个Session，并将用户的某些信息保存在Session
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getName());
            session.setMaxInactiveInterval(60);//60s
            //但是当cookie关闭后，用于保存SessionID的JSESSIONID会消失(此时cookie并没有过期) ，所以得将JSESESSION持久化
            Cookie sessionId = new Cookie("JSESESSIONID", session.getId());
            sessionId.setMaxAge(60);//60s
            sessionId.setPath("/");
            response.addCookie(sessionId);



            if(userService.Authentication(user.getName(),user.getPwd())==null){
                return "login";
            }else {
                session.setAttribute("name", user.getName());
                return "redirect:/user";
            }
        }
    }
}
