package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.HistoryVO;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.mapper.HistoryImp;
import cn.edu.hqu.library.service.Impl.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public ReturnBean postponeBook(@RequestBody(required = false)List<String> codeList, @ModelAttribute("name")String userId)
    {
        for(String code:codeList){
            borrowService.postponeBook(userId,code);
        }
        return getSuccess("success");
    }

    @ResponseBody
    @RequestMapping("deleteHistory")
    public ReturnBean deleteHistory(@RequestBody(required = false) List<String> idList)
    {
        for(String id:idList)
        {
            historyImp.deleteHistory(id);
        }
        return getSuccess("success");
    }



}
