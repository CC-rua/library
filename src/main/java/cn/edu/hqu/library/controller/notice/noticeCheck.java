package cn.edu.hqu.library.controller.notice;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chakangonggao")
public class noticeCheck {
    @Autowired
    NoticeService noticeService;
    @RequestMapping(method = RequestMethod.GET)
    public String ShowNoticeCheck(Model model,Integer noticeId){
     //   noticeId=1;
        Notice notice = noticeService.findNoticeByNoticeId(noticeId);
        model.addAttribute("Notice",notice);
        return "chakangonggao";
    }
}
