package cn.edu.hqu.library.controller.RankingList;

import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("jieyuepaihang")
public class RankingController {

    @Autowired
    private BookService bookService;



    @RequestMapping(method = RequestMethod.GET)
    public String ShowRankingPage(Model model){
        List<Rank> ranks=bookService.FindRankListByJiaoFu("是");
        List<Rank> ranks2=bookService.FindRankList("小说");
        model.addAttribute("ranks",ranks);
        model.addAttribute("ranks2",ranks2);
        return "jieyuepaihang";
    }
}
