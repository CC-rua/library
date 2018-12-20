//package cn.edu.hqu.library.service.Impl;
//
//import cn.edu.hqu.library.controller.vo.BookVo;
//import cn.edu.hqu.library.entity.Book;
//import cn.edu.hqu.library.entity.Bookmessage;
//import cn.edu.hqu.library.entity.Borrow;
//import cn.edu.hqu.library.repository.BorrowRepository;
//import cn.edu.hqu.library.repository.zx.BookMsgRepository;
//import cn.edu.hqu.library.repository.zx.BookRepository;
//import cn.edu.hqu.library.util.StaticData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import sun.plugin2.applet.context.NoopExecutionContext;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class BookService  {
//
//    @Autowired
//    BookMsgRepository bookMsgRepository;
//
//    @Autowired
//    BookRepository bookRepository;
//
//    @Autowired
//    BorrowRepository borrowRepository;
//
//    //功能 新增 批量新增 出借 查看 还书 删除
//
//    //新增
//    public void addBook(Book book)
//    {
//        bookRepository.save(book);
//
//    }
//
//    public void addBookList(List<Book> list)
//    {
//        for(Book book:list)
//        {
//            bookRepository.save(book);
//        }
//    }
//
//    public void borrowBook(String bookId,String code,String userId)//需要定位到某一本书 然后将其出借给某个人
//    {
//        Book book = bookRepository.findByBookIdAndCode(bookId,code);
//        Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(bookId);
//        book.setState(StaticData.BOOK_STATUS_WAIT_QU);
//        Date now = new Date(System.currentTimeMillis());
//        Date etime = new Date(System.currentTimeMillis()+1000*60*60*24* StaticData.JIEYUEQI);
//        Borrow borrow = new Borrow(userId,code,now,etime,bookmessage.getJiaofu(),book.getQuality(),null);
//        borrowRepository.save(borrow);
//    }
//
//    public BookVo findBookVoByBookCodeAndBookId(String bookId,String code)
//    {
//        Book book = bookRepository.findByBookIdAndCode(bookId,code);
//        Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(bookId);
//        BookVo bookVo = new BookVo(bookId,bookmessage.getName(),bookmessage.getJiaofu(),bookmessage.getKind(),bookmessage.getPublisher(),bookmessage.getAuthor(),book.getQuality(),book.getCode());
//        return bookVo;
//    }
//
//    public void deleteBook(String bookId,String code)
//    {
//
//        Book book = bookRepository.findByBookIdAndCode(bookId,code);
//        book.setIsDelete(StaticData.BOOK_DELETE_IS_DELETE);
//        bookRepository.save(book);
//
//    }
//
//    //还书  需要精确到书 需要归还时的状态
//    public void giveBack(String bookId,String code,String status)
//    {
//        Book book =bookRepository.findByBookIdAndCode(bookId,code);
//        book.setState(StaticData.BOOK_STATUS_ALREADY_BACK);
//        Borrow borrow = borrowRepository.findByUserIdAndCode(bookId,code);
//        borrow.setReturnStatus(status);
//        borrowRepository.save(borrow);
//    }
//
//}
