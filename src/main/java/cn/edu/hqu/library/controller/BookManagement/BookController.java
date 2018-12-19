package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.AddBookVo;
import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.zx.vo.BookMsgVo;
import cn.edu.hqu.library.controller.zx.vo.BookVo;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    BookService bookService;


    //最新图书
    @RequestMapping("findNewBook")
    public String findNewBook(Model model)
    {
        List<NewBookInfo> list =  bookService.findNewBookInfo();
        model.addAttribute("list",list);
        return "newBook";
    }

    //推荐图书
    @RequestMapping("recommendBook")
    public String recommendBook(Model model)
    {
        List<RecommendBookInfo> list = bookService.findRecommendBook();
        model.addAttribute("list",list);
        return "recommendBook";
    }

    //通过Id查看图书的详细信息
    @RequestMapping(value = "jumpBookMsgByBookId")
    public String findBookMsgByBookId(String bookId, Model model)
    {
        BookMsgVo bookMsgVo = bookService.findBookMsgByBookId(bookId);
        model.addAttribute("bookInfo",bookMsgVo);
        return "bookMsgInfo";
    }

    @RequestMapping("addBookList")
    public ReturnBean addBookList(AddBookVo addBookVo,String quality)
    {
        Random random = new Random(System.currentTimeMillis());
        String code ="";
        Book book =new Book(code,addBookVo.getBookId(), StaticData.BOOK_QUALITY_GOOD,StaticData.BOOK_DELETE_NOT_DELETE,quality);
        for(int i = 0;i<addBookVo.getCount();i++)
        {
//            random. 这里有BUG
            book.setCode(null);
            bookService.addBook(book);
        }
        return getSuccess("success");
    }

    @RequestMapping("findBookBuIdAndCode")
    public ReturnBean findBookBuIdAndCode(String bookId,String code)
    {
        BookVo bookVo = bookService.findBookVoByBookCodeAndBookId(bookId,code);
        return getSuccess("success",bookVo,1);
    }

    @RequestMapping("deleteBook")
    public ReturnBean deleteBook(String bookId,String code)
    {
        bookService.deleteBook(bookId,code);
        return getSuccess("success");
    }

    @RequestMapping("borrowOutBook")
    public ReturnBean borrowOutBook(String borrowUserId,String bookId,String code)
    {
        bookService.borrowBook(bookId,code,borrowUserId);
        return getSuccess("success");
    }

    @RequestMapping("giveBackBook")
    public ReturnBean giveBackBook(String borrowUserId,String bookId,String code)
    {
        bookService.giveBack(bookId,code,borrowUserId);
        return getSuccess("success");
    }

    @ResponseBody
    @RequestMapping("findBookInfo")
    public ReturnBean findBookListInfo(@RequestParam(required = false,defaultValue = "")String code,
                                       @RequestParam(required = false,defaultValue = "")String name,
                                       @RequestParam(required = false,defaultValue = "")String kind,
                                       @RequestParam(required = false,defaultValue = "")String jiaofu,
                                       @RequestParam(required = false,defaultValue = "")String type,
                                       @RequestParam(required = false,defaultValue = "")String status,
                                       @RequestParam(required = false,defaultValue = "")String quality,
                                       @RequestParam(required = false,defaultValue = "")String author
                                       )
            //参数 提取码 书名 性质 类别 状态 图书状况 作者
            //     code,name,jiaofu,kind,status,quality,author
    {
        List<BookVo> list = bookService.findBookInfo(code,name,kind,jiaofu,type,status,quality,author);
        return getSuccess("success",list, list.size());
    }


}
