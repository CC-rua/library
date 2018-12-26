package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.*;
import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("tushutuijian")
public class BookRecom extends BaseController {

    @Autowired
    BookService bookService;
    //推荐图书
    @RequestMapping(method = RequestMethod.GET)
    public String recommendBook(Model model)
    {
        List<RecommendBookInfo> list = bookService.findRecommendBook();
        model.addAttribute("list",list);
        return "tushutuijian";
    }

}
