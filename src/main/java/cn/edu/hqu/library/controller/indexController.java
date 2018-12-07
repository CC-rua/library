package cn.edu.hqu.library.controller;

import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"/","index"})
public class indexController {
    @Autowired
    BookService bookService;
    @RequestMapping
    public String index()
    {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchBook(@RequestParam(value = "name")String name)
    {
        List<BookInfo> bookInfos;
        bookInfos= bookService.FindBookInfoByName(name);
        return "index";
    }


}
