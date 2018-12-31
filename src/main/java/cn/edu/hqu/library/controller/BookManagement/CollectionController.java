package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;

import cn.edu.hqu.library.controller.vo.CollectionInfo;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.Impl.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"name","pwd"})
public class CollectionController extends BaseController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping("collection")
    public String findCollectionByUserId(@ModelAttribute("name")String name, Model model)
    {
        List<CollectionInfo> list = collectionService.findCollectionInfoByUserId(name);
        model.addAttribute("list",list);
        return "collection";
    }


    @ResponseBody
    @RequestMapping("CollectionBook")
    public ReturnBean CollectionBook(@ModelAttribute("name")String userId, String bookId)
    {
        collectionService.collectionBook(userId,bookId);
        return getSuccess("success");
    }
}
