package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chakantushuchuru")
public class BookCheck {
    @Autowired
    BookService bookService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowBookCheckPage(Model model,String code){
        BookInfo bookInfo=bookService.FindBookInfoByCode(code);
        model.addAttribute("BookInfo", bookInfo);
        return "chakantushuchuru";
    }
}
