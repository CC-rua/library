package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("xinjintushu")

public class NewBookController {

    @Autowired
    BookService bookService;
    //最新图书
    @RequestMapping(method = RequestMethod.GET)
    public String findNewBook(Model model)
    {
        List<NewBookInfo> list =  bookService.findNewBookInfo();
        model.addAttribute("list",list);
        return "xinjintushu";
    }
}
