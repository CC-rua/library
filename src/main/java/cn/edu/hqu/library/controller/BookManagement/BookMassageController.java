package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.Impl.BookManagementService;
import cn.edu.hqu.library.service.Impl.BorrowService;
import cn.edu.hqu.library.service.Impl.CollectionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes(value = {"name","roleId"})
@RequestMapping("tushuxinxiguanli")
public class BookMassageController extends BaseController {

    @Autowired
    BookService bookService;

    @Autowired
    BookManagementService managementService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    BorrowService borrowService;

    @RequestMapping(method = RequestMethod.GET)
    public String ShowBookMsgPage(Model model){
        List<BookMsgVo> list = bookService.findBookMsgInfo( "", "", "", "", "", "");
        model.addAttribute("list3", list);
        return "tushuxinxiguanli";
    }
    //已经移入BookCollection和BorrowController
//    //收藏 借书
//    @ResponseBody
//    @RequestMapping("CollectionBook")
//    public ReturnBean CollectionBook(@ModelAttribute("name")String userId, String bookId)
//    {
//        collectionService.collectionBook(userId,bookId);
//        return getSuccess("success");
//    }

//    @ResponseBody
//    @RequestMapping("BorrowBook")
//    public ReturnBean BorrowBook(@ModelAttribute("name")String userId, String bookId)
//    {
//        borrowService.UserBorrowSomeBook(userId,bookId);
//        return getSuccess("success");
//    }

    @RequestMapping("findAllBookMsg")
    @ResponseBody
    //这个方法还没想好怎么实现
    public List<BookMsgVo> findAllBookMsg()
    {
        return null;
    }


    @RequestMapping("addBookMsgJump")
    public  String addBook(Model model){
        Bookmessage bookmessage = new Bookmessage();
        model.addAttribute("Bookmessage",bookmessage);
        return "xinzengtushu";
    }

    @RequestMapping("addBookMsg")
    public String addBookMsg(@RequestParam(required = false,defaultValue = "") String bookId,
                                 @RequestParam(required = false,defaultValue = "")String name,
                                 @RequestParam(required = false,defaultValue = "")String jiaofu,
                                 @RequestParam(required = false,defaultValue = "")String pubsiher,
                                 @RequestParam(required = false,defaultValue = "")String author,
                                 @RequestParam(required = false,defaultValue = "")String introduction)
    {
        Bookmessage bookmessage =new Bookmessage(bookId,name,jiaofu,"",author,pubsiher,introduction);

        managementService.addBookMsg(bookmessage);
        return "redirect:/tushuxinxiguanli";
    }
    @RequestMapping("xiugaitushuxinxi")
    public String jumpToUpdateBookMsg(String bookId,Model model)
    {
        BookMsgVo bookMsgVo = bookService.findBookMsgByBookId(bookId);
        model.addAttribute("bookInfo",bookMsgVo);
        return "xiugaitushuxinxi";
    }

    @RequestMapping(value = "updateBookMsg",method = RequestMethod.POST)
    public String updateBookMsg(String bookId,String bookName,String jiaofu,String kind,String publisher,String author,String introduce)
    {
        Bookmessage bookmessage = new Bookmessage(bookId,bookName,jiaofu,kind,author,publisher,introduce);
        managementService.updateBookMsg(bookmessage);
        return "redirect:/tushuxinxiguanli";
    }

    @ResponseBody
    @RequestMapping("deleteBookMsg")
    public ReturnBean deleteBookMsg(String bookMsgId)
    {
        managementService.deleteBookMsg(bookMsgId);
        return getSuccess("success");
    }


    @ResponseBody
    @RequestMapping(value = "findBookMsgByBookId",method = RequestMethod.POST)
    public ReturnBean findBookMsgByBookId(String bookId)
    {
        Bookmessage bookmessage= managementService.findBookMsgByBookId(bookId);
        return getSuccess("success",bookmessage,1);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findBookMsgInfo(Model model,String bookId,String bookName,String jiaofu,String type,String publisher,String author)
    {
        List<BookMsgVo> list = bookService.findBookMsgInfo( bookId, bookName, jiaofu, type, publisher, author);
        model.addAttribute("list3",list);
        return"tushuxinxiguanli::bookform3";
    }

}
