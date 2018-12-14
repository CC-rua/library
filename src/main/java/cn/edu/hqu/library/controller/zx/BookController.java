package cn.edu.hqu.library.controller.zx;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController extends BaseController {

    @Autowired
    BookService bookService;


    @RequestMapping("findNewBook")
    public String findNewBook(Model model)
    {
        List<NewBookInfo> list =  bookService.findNewBookInfo();
        model.addAttribute("list",list);
        return "newBook";
    }

    @RequestMapping
    public String recommendBook(Model model)
    {
        List<RecommendBookInfo> list = bookService.findRecommendBook();
        model.addAttribute("list",list);
        return "recommendBook";
    }

}
