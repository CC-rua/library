package cn.edu.hqu.library.controller;

import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/","start"})
public class indexController extends BaseController{

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model)
    {
        List<BookInfo> bookInfos;
        bookInfos= bookService.FindBookInfoByName("");
        model.addAttribute("list", bookInfos);
        return "start";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchBook(Model model,@RequestParam(value = "name")String name)
    {
        List<BookInfo> bookInfos;
        bookInfos= bookService.FindBookInfoByName(name);
        model.addAttribute("list", bookInfos);
        return "start::bookform";
    }


}
