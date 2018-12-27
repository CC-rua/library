package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.HistoryVO;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.mapper.HistoryImp;
import cn.edu.hqu.library.service.Impl.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class HistoryController extends BaseController {

    @Autowired
    HistoryImp historyImp;

    @Autowired
    BorrowService borrowService;

    @RequestMapping("liulanlishi")
    public String findAllHistory(@ModelAttribute("name") String userId, Model model)
    {
        List<HistoryVO> list =  historyImp.findAllHistoryByUserId(userId);
        model.addAttribute("list",list);
        return "liulanlishi";
    }

    @RequestMapping("postponeBook")
    public ReturnBean postponeBook(String code, @ModelAttribute("name")String userId)
    {
        borrowService.postponeBook(userId,code);
        return getSuccess("success");
    }



}
