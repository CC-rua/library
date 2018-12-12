package cn.edu.hqu.library.controller.RankingList;

import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RankingController {
    @Autowired
    BookService bookService;



    @RequestMapping("rank")
    public String ShowRankingPage(Model model){
        List<Rank> ranks=bookService.FindRankList("计算机");
        List<Rank> ranks2=bookService.FindRankList("数学");
        model.addAttribute("ranks",ranks);
        model.addAttribute("ranks",ranks2);
        return "rank";
    }
}
