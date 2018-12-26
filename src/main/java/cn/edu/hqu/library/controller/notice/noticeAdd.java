package cn.edu.hqu.library.controller.notice;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("xinzenggonggao")
public class noticeAdd {
    @Autowired
    NoticeService noticeService;
    @RequestMapping(method = RequestMethod.GET)
     String ShowNoticeAdd(Model model){
        Notice notice1 = new Notice();
        model.addAttribute("Notice", notice1);
        return "xinzenggonggao";
    }
    //增
    @RequestMapping(method = RequestMethod.POST)
    public void AddNotice(Model model,Notice notice1){
        Integer getid=notice1.getNoticeId();
        if(noticeService.findNoticeByNoticeId(getid)==null){
            noticeService.addNotice(notice1);
        }
    }
}
