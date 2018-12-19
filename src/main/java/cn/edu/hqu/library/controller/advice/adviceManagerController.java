package cn.edu.hqu.library.controller.advice;


import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/adviceManager")
public class adviceManagerController {
    private final AdviceService adviceService;

    @Autowired
    public adviceManagerController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String  ShowadviceManagerPage(Model model){
        model.addAttribute("Alladvice",adviceService.FindAllAdvice());
        return "adviceManager";
    }
    
    
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void Addadvice(@RequestBody(required = false) Advice advice1){
            adviceService.addAdvice(advice1);
    }
    //删
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  void Deleteadvice(@RequestBody(required = false) List<Integer> adviceId){
        //发回id串
        for(int getid:adviceId){
            if(adviceService.findAdviceByAdviceId(getid)!=null){
                adviceService.DeleteByAdviceId(getid);
            }
        }
    }
    //改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void UpDateadvice(@RequestBody(required = false) List<Advice> adviceList){
        for(Advice advice1:adviceList){
            Integer adviceId=advice1.getAdviceId();
            if(adviceService.findAdviceByAdviceId(adviceId)!=null){
                adviceService.addAdvice(advice1);
            }
        }
    }
    //查
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Advice> Searchadvice(@RequestBody(required = false) Advice advice1) {
        //需要一个advice的json
        return adviceService.findAdviceByConditions(advice1.getAdviceId(),advice1.getName(), advice1.getMessage(),advice1.getState());
    }
}
