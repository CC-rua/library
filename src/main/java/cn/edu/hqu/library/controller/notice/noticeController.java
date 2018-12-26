package cn.edu.hqu.library.controller.notice;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("gonggao")
public class noticeController {

    private final NoticeService noticeService;

    @Autowired
    public noticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public  String ShowNoticePage(Model model){
        List<Notice> notices=noticeService.FindAllNotice();
        List<Notice> beforeNow=new ArrayList<>();
        List<Notice> afterNow=new ArrayList<>();
        Date date = new Date();
        for(Notice notice:notices){
            if(notice.getBtime()==null||notice.getEtime()==null){
                afterNow.add(notice);
            }else if(!notice.getBtime().before(date)&&!notice.getEtime().before(date)) {
                beforeNow.add(notice);
           }else if(!notice.getEtime().before(date)){
               afterNow.add(notice);
           }
        }
        model.addAttribute("beginNotice",beforeNow);
        model.addAttribute("afterNotice",afterNow);
        return "gonggao";
    }
}
