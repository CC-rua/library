package cn.edu.hqu.library.controller.BookManagement;

import cn.edu.hqu.library.controller.BaseController;
import cn.edu.hqu.library.controller.vo.AddBookVo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.controller.vo.BookVo;
import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.ReturnBean;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.Impl.BookManagementService;
import cn.edu.hqu.library.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("churukuguanli")
public class BookController extends BaseController {

    @Autowired
    BookService bookService;

    @Autowired
    BookManagementService bookManagementService;

    @RequestMapping(method = RequestMethod.GET)
    public  String churukuguanli(Model model){
        List<BookVo> list = bookService.findBookInfo("","","","","","","","");
        model.addAttribute("list2",list );
        return "churukuguanli";
    }


    //批量添加图书
    @RequestMapping("addBookList")
    public ReturnBean addBookList(AddBookVo addBookVo,String quality)
    {
        String code = UUID.randomUUID().toString();
        Book book =new Book(code,addBookVo.getBookId(), StaticData.BOOK_QUALITY_GOOD,StaticData.BOOK_DELETE_NOT_DELETE,quality);
        for(int i = 0;i<addBookVo.getCount();i++)
        {
//            这里改成了uuid生成的id 会比较复杂
            book.setCode(code);
            bookService.addBook(book);
        }
        return getSuccess("success");
    }

    //
    @RequestMapping("findBookByIdAndCode")
    public ReturnBean findBookByIdAndCode(String bookId,String code)
    {
        BookVo bookVo = bookService.findBookVoByBookCodeAndBookId(bookId,code);
        return getSuccess("success",bookVo,1);
    }

    @RequestMapping("deleteBook")
    public ReturnBean deleteBook(String bookId,String code)
    {
        bookService.deleteBook(bookId,code);
        return getSuccess("success");
    }

    @RequestMapping("deleteBookList")
    public ReturnBean deleteBookList(List<String> bookIdList,List<String> codeList)
    {
        for(int i = 0;i<bookIdList.size();i++)
        {
            bookService.deleteBook(bookIdList.get(i),codeList.get(i));
        }
        return getSuccess("success");
    }

    @RequestMapping("borrowOutBook")
    public ReturnBean borrowOutBook(@ModelAttribute("name")String borrowUserId,String bookId)
    {
        String code = bookService.findBookCodeByBookId(bookId);
        bookService.borrowBook(bookId,code,borrowUserId);
        return getSuccess("success");
    }

    @RequestMapping("giveBackBook")
    public String giveBackBook(String borrowUserId, String bookId, String code)
    {
        bookService.giveBack(bookId,code,borrowUserId);
        return "redirect:/churukuguanli";
    }

    @RequestMapping("xiugaitushuchuru")
    public String xiugaitushuchuru(String code,Model model)
    {
//        bookService.findBookVoByBookCodeAndBookId()
//        model.addAttribute();
        List<BookVo> list = bookService.findBookInfo(code,"","","","","","","");
        if(list!=null)
        {
            model.addAttribute("bookInfo",list.get(0));
        }else{
            model.addAttribute("bookInfo",null);
        }
        return "xiugaitushuchuru";
    }

    @RequestMapping("updateBook")
    public String updateBook(String code,String quality,String status,String bookId)
    {
        Book book = new Book(code,bookId,status,0,quality);
        bookService.updateBook(book);
        return "redirect:/churukuguanli";
    }

    @RequestMapping(value = "findBookInfo",method = RequestMethod.POST)
    public String findBookListInfo(    @RequestParam(value = "code",required = false,defaultValue = "")String code,
                                       @RequestParam(value = "name",required = false,defaultValue = "")String name,
                                       @RequestParam(value = "kind",required = false,defaultValue = "")String kind,
                                       @RequestParam(value = "jiaofu",required = false,defaultValue = "")String jiaofu,
                                       @RequestParam(value = "type",required = false,defaultValue = "")String type,
                                       @RequestParam(value = "status",required = false,defaultValue = "")String status,
                                       @RequestParam(value = "quality",required = false,defaultValue = "")String quality,
                                       @RequestParam(value = "author",required = false,defaultValue = "")String author ,
                                      Model model )
            //参数 提取码 书名 性质 类别 状态 图书状况 作者
            //     code,name,jiaofu,kind,status,quality,author
    {
        List<BookVo> list = bookService.findBookInfo(code,name,kind,jiaofu,type,status,quality,author);

//        for(BookVo bookVo:list)
//        {
//            bookVo.setCode(bookVo.getCode().substring(0,7));
//        }

        model.addAttribute("list2", list);
        return "churukuguanli::bookform";
    }


}
