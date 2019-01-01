package cn.edu.hqu.library.controller.notice;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.entity.User;
import cn.edu.hqu.library.service.NoticeService;
import cn.edu.hqu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("xiugaigonggao")
public class noticeUpdate {
    @Autowired
    NoticeService noticeService;
    @RequestMapping
    public String ShowNoticeCheck(Model model, Integer noticeId){
        //   noticeId=1;
        Notice notice = noticeService.findNoticeByNoticeId(noticeId);
        model.addAttribute("Notice",notice);

        return "xiugaigonggao";
    }
    //改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  UpDatenotice( Notice notice){
            Integer getid=notice.getNoticeId();
            notice.setEtime(noticeService.findNoticeByNoticeId(notice.getNoticeId()).getEtime());
            if(noticeService.findNoticeByNoticeId(getid)!=null){
                noticeService.addNotice(notice);
        }
        return "redirect:/gonggaoguanli";
    }
}
