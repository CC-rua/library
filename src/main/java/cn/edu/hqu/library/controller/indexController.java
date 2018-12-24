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
@RequestMapping(value = {"/","index"})
public class indexController extends BaseController{

    @Autowired
    BookService bookService;

//    @RequestMapping
//    public String index()
//    {
//        return "index";
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public ReturnBean searchBook(@RequestParam(value = "name")String name)
//    {
//        List<BookInfo> bookInfos;
//        bookInfos= bookService.FindBookInfoByName(name);
//        return getSuccess("success",bookInfos,bookInfos.size());
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model)
    {
        List<BookInfo> bookInfos;
        bookInfos= bookService.FindBookInfoByName("");
        model.addAttribute("list", bookInfos);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchBook(Model model,@RequestParam(value = "name")String name)
    {
        List<BookInfo> bookInfos;
        bookInfos= bookService.FindBookInfoByName(name);
        model.addAttribute("list", bookInfos);
        return "index::bookform";
    }
//    @RequestMapping("/ajaxTest")
//    public String test(Model model){
//        System.out.println("ajaxTest");
//        List<String> list = new ArrayList<>(10);
//        for(int i=0;i<10;i++){
//            list.add("hello"+i);
//        }
//        model.addAttribute("aa",list);
//        return "index::div1";
//    }

}
