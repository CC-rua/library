package cn.edu.hqu.library.controller;

import cn.edu.hqu.library.controller.vo.BorrorForm;
import cn.edu.hqu.library.controller.vo.ReturnForm;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/borrow")
@SessionAttributes({"name"})
public class borrowController {
    private final BookService bookService;

    @Autowired
    public borrowController(BookService borrowService) {
        this.bookService = borrowService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ShowBorrowPage(@ModelAttribute("name")String name, Model model){
        List<BookInfo>borrows;
        List<BookInfo>returnBorrows;
        borrows= bookService.FindBorrowInfoByName(name);
        returnBorrows=bookService.FindReturnBorrowByName(name);
        List<BorrorForm> result = new ArrayList<>();
        List<ReturnForm> result2 = new ArrayList<>();
        for(BookInfo borrow : borrows)
        {
            result.add(new BorrorForm(borrow));
        }
        for(BookInfo borrow : returnBorrows)
        {
            result2.add(new ReturnForm(borrow));
        }
        model.addAttribute("borrows",result);
        model.addAttribute("Returnborrows",result2);
        return "borrow";
    }
}
