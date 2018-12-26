package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.vo.HistoryVO;
import cn.edu.hqu.library.mapper.HistoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    HistoryImp historyImp;

    @RequestMapping("liulanlishi")
    public String findAllHistory(String userId, Model model)
    {
        List<HistoryVO> list =  historyImp.findAllHistoryByUserId(userId);
        model.addAttribute("list",list);
        return "liulanlishi";
    }

}
