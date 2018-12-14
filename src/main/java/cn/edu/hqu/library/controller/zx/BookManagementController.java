//package cn.edu.hqu.library.controller.zx;
//
//import cn.edu.hqu.library.controller.BaseController;
//import cn.edu.hqu.library.entity.Book;
//import cn.edu.hqu.library.entity.ReturnBean;
//import cn.edu.hqu.library.repository.zx.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class BookManagementController extends BaseController {
//
//    @Autowired
//    BookRepository bookRepository;
//
//    @RequestMapping
//    public ReturnBean addBook(Book book)
//    {
//        bookRepository.save(book);
//        return getSuccess("success");
//    }
//
//    @RequestMapping
//    public ReturnBean deleteBook(String bookId)
//    {
//        Book book = new Book();
//        book.setBookId(bookId);
//        bookRepository.delete(book);
//        return getSuccess("success");
//    }
//
//    @RequestMapping
//    public ReturnBean updateBook(Book book)
//    {
//        bookRepository.save(book);
//        return getSuccess("success");
//    }
//
////    @RequestMapping("findAllBookInfo")
//////    public ReturnBean findAllBook()
//////    {
//////        bookRepository.findAll();
//////        return getSuccess("success");
//////    }
//}
