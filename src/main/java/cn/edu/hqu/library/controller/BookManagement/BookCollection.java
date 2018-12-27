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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
@RequestMapping("wodeshoucang")
public class BookCollection extends BaseController{

    @Autowired
    BookService bookService;

    @Autowired
    BookManagementService managementService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    BorrowService borrowService;

    @RequestMapping(method = RequestMethod.GET)
    public String CollectionBook(Model model,@ModelAttribute("name")String userId)
    {
        //查找当前用户的收藏记录并添入model,我的收藏页面也没有绑定

     //  model.addAttribute( "list4",collectionService.collectionBook(userId,bookId));
        return "wodeshoucang";
    }
    //收藏
    @ResponseBody
    @RequestMapping("CollectionBook")
    public ReturnBean CollectionBook(@ModelAttribute("name")String userId, String bookId)
    {
        collectionService.collectionBook(userId,bookId);
        return getSuccess("success");
    }

}
