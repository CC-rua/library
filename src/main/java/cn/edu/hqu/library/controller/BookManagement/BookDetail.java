package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.History;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.mapper.HistoryImp;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.Impl.BookManagementService;
import cn.edu.hqu.library.service.Impl.BorrowService;
import cn.edu.hqu.library.service.Impl.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("tushuxiangqing")
public class BookDetail{
    @Autowired
    BookManagementService managementService;
    @Autowired
    HistoryImp historyImp;




    @RequestMapping(method = RequestMethod.GET)
    public String findBookMsgByBookId(@RequestParam(required = false,defaultValue = "4") String bookId, HttpSession session, Model model)
    {

        Bookmessage bookmessage= managementService.findBookMsgByBookId(bookId);
        String userId = (String) session.getAttribute("name");
        if(userId != null && userId != "")
        {
            historyImp.addHistory(userId,bookId);
        }

        model.addAttribute("bookMsg", bookmessage);
        return "tushuxiangqing";
    }


}
