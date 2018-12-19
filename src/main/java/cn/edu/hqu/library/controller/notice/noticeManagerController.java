package cn.edu.hqu.library.controller.notice;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("noticeManager")
public class noticeManagerController {

    private final NoticeService noticeService;

    @Autowired
    public noticeManagerController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String  ShowNoticeManagerPage(Model model){
        model.addAttribute("Allnotice",noticeService.FindAllNotice());
        return "noticeManager";
    }
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void AddNotice(@RequestBody(required = false) Notice notice1){
        Integer getid=notice1.getNoticeId();
        if(noticeService.findNoticeByNoticeId(getid)==null){
            noticeService.addNotice(notice1);
        }
    }
    //删
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  void Deletenotice(@RequestBody(required = false) List<Integer> noticeId){
        //发回id串
        for(Integer getid:noticeId){
            if(noticeService.findNoticeByNoticeId(getid)!=null){
                noticeService.DeleteByNoticeId(getid);
            }
        }
    }
    //改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void UpDatenotice(@RequestBody(required = false) List<Notice> noticeList){
        for(Notice notice1:noticeList){
            Integer getid=notice1.getNoticeId();
            if(noticeService.findNoticeByNoticeId(getid)!=null){
                noticeService.addNotice(notice1);
            }
        }
    }
    //查
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Notice> Searchnotice(@RequestBody(required = false) Notice notice1) {
        //需要一个notice的json
        return noticeService.findNoticeByConditions(notice1.getNoticeId(), notice1.getMsg());
    }
}
