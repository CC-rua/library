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
@RequestMapping("tushuxiangqing")
public class BookDetail{
    @Autowired
    BookManagementService managementService;

    @RequestMapping(method = RequestMethod.GET)
    public String findBookMsgByBookId(String bookId)
    {
        bookId="1";
        Bookmessage bookmessage= managementService.findBookMsgByBookId(bookId);
        return "tushuxiangqing";
    }


}
