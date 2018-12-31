package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.AddBookVo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.controller.vo.BookVo;
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
@RequestMapping("chakantushuxinxi")
public class BookInfoCheck {

    @Autowired
    BookService bookService;
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    //通过Id查看图书的详细信息
    public String findBookMsgByBookId(@RequestParam(required = false,defaultValue = "1") String bookId, Model model)
    {
        //bookId="1";
        BookMsgVo bookMsgVo = bookService.findBookMsgByBookId(bookId);
        model.addAttribute("bookInfo",bookMsgVo);
        return "chakantushuxinxi";
    }
}
