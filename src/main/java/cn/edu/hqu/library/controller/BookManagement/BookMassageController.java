package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.Impl.BookManagementService;
import cn.edu.hqu.library.service.Impl.BorrowService;
import cn.edu.hqu.library.service.Impl.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
@RequestMapping("bookMsg")
public class BookMassageController extends BaseController {

    @Autowired
    BookService bookService;

    @Autowired
    BookManagementService managementService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    BorrowService borrowService;

    //收藏 借书

    @ResponseBody
    @RequestMapping("CollectionBook")
    public ReturnBean CollectionBook(@ModelAttribute("name")String userId, String bookId)
    {
        collectionService.collectionBook(userId,bookId);
        return getSuccess("success");
    }

    @ResponseBody
    @RequestMapping("BorrowBook")
    public ReturnBean BorrowBook(@ModelAttribute("name")String userId, String bookId)
    {
        borrowService.UserBorrowSomeBook(userId,bookId);
        return getSuccess("success");
    }

    @RequestMapping("findAllBookMsg")
    @ResponseBody
    //这个方法还没想好怎么实现
    public List<BookMsgVo> findAllBookMsg()
    {
        return null;
    }

    @ResponseBody
    @RequestMapping("addBookMsg")
    public ReturnBean addBookMsg(Bookmessage bookmessage)
    {
        managementService.addBookMsg(bookmessage);
        return getSuccess("success");
    }

    @ResponseBody
    @RequestMapping("updateBookMsg")
    public ReturnBean updateBookMsg(Bookmessage bookmessage)
    {
        managementService.updateBookMsg(bookmessage);
        return getSuccess("success");
    }

    @ResponseBody
    @RequestMapping("deleteBookMsg")
    public ReturnBean deleteBookMsg(Bookmessage bookmessage)
    {
        managementService.deleteBookMsg(bookmessage);
        return getSuccess("success");
    }


    @ResponseBody
    @RequestMapping(value = "findBookMsgByBookId",method = RequestMethod.POST)
    public ReturnBean findBookMsgByBookId(String bookId)
    {
        Bookmessage bookmessage= managementService.findBookMsgByBookId(bookId);
        return getSuccess("success",bookmessage,1);
    }

    @ResponseBody
    @RequestMapping("findBookMsgInfo")
    public ReturnBean findBookMsgInfo(String bookId,String bookName,String jiaofu,String type,String publisher,String author)
    {
        List<BookMsgVo> list = bookService.findBookMsgInfo( bookId, bookName, jiaofu, type, publisher, author);
        return getSuccess("success",list,list.size());
    }

}
