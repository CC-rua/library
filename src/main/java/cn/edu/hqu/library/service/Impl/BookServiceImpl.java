package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.vo.BookMsgVo;
import cn.edu.hqu.library.controller.vo.BookVo;
import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.mapper.BookImp;
import cn.edu.hqu.library.repository.BorrowRepository;
import cn.edu.hqu.library.repository.zx.BookMsgRepository;
import cn.edu.hqu.library.repository.zx.BookRepository;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;
import cn.edu.hqu.library.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookImp bookImp;
    private final BorrowRepository borrowRepository;
    private final BookMsgRepository bookMsgRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookImp bookImp, BorrowRepository borrowRepository, BookMsgRepository bookMsgRepository, BookRepository bookRepository) {
        this.bookImp = bookImp;
        this.borrowRepository = borrowRepository;
        this.bookMsgRepository = bookMsgRepository;
        this.bookRepository = bookRepository;
    }



    @Override
    public List<Borrow> borrowInfo(String userId) {
        return borrowRepository.findAllByUserId(userId);
    }

    @Override
    public List<BookInfo> FindBorrowInfoByName(String name) {
        return bookImp.FindBorrowInfoByName(name);
    }

    @Override
    public List<BookInfo> FindReturnBorrowByName(String name) {
        return bookImp.FindReturnBorrowByName(name);
    }

    @Override
    public List<BookInfo> FindBookInfoByName(String name) {
        return bookImp.FindBookInfoByName(name);
    }

    @Override
    public List<Rank> FindRankList(String kind){
        return bookImp.FindRankList(kind);
    }

    @Override
    public List<Rank> FindRankListByJiaoFu(String JiaoFu) {
        return bookImp.FindRankListByJiaoFu(JiaoFu);
    }

    @Override
    public List<NewBookInfo> findNewBookInfo()
    {
        return bookImp.FindBookByTimeDesc();
    }

    @Override
    public List<RecommendBookInfo> findRecommendBook() {
        return bookImp.findRecommendBook();
    }

    @Override
    public BookMsgVo findBookMsgByBookId(String bookId) {
        BookMsgVo bookMsgVo = new BookMsgVo();
        Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(bookId);
        int freeNum = bookRepository.countAllByBookIdAndState(bookId,"0");
        bookMsgVo.setBookName(bookmessage.getName());
        bookMsgVo.setAuthor(bookmessage.getAuthor());
        bookMsgVo.setBookId(bookmessage.getBookId());
        bookMsgVo.setFreeNum(freeNum);
        bookMsgVo.setIntroduction(bookmessage.getIntroduction());
        bookMsgVo.setKind(bookmessage.getKind());
        bookMsgVo.setPublisher(bookmessage.getPublisher());
        return bookMsgVo;

    }


    //功能 新增 批量新增 出借 查看 还书 删除

    //新增
    @Override
    public void addBook(Book book)
    {
        bookRepository.save(book);

    }

    @Override
    public void addBookList(List<Book> list)
    {
        for(Book book:list)
        {
            bookRepository.save(book);
        }
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void borrowBook(String bookId, String code, String userId)//需要定位到某一本书 然后将其出借给某个人
    {
        Book book = bookRepository.findByBookIdAndCode(bookId,code);
        Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(bookId);
        book.setState(StaticData.BOOK_STATUS_WAIT_QU);
        bookRepository.saveAndFlush(book);
        Date now = new Date(System.currentTimeMillis());
        Date etime = new Date(System.currentTimeMillis()+1000*60*60*24* StaticData.JIEYUEQI);
        Borrow borrow = new Borrow(userId,code,now,etime,bookmessage.getJiaofu(),book.getQuality(),"0");
        borrowRepository.save(borrow);
    }

    @Override
    public BookVo findBookVoByBookCodeAndBookId(String bookId, String code)
    {
        Book book = bookRepository.findByBookIdAndCode(bookId,code);
        Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(bookId);
        BookVo bookVo = new BookVo(bookId,bookmessage.getName(),bookmessage.getJiaofu(),bookmessage.getKind(),bookmessage.getPublisher(),bookmessage.getAuthor(),book.getQuality(),book.getState(),book.getCode());
        return bookVo;
    }

    @Override
    public void deleteBook(String bookId, String code)
    {

        Book book = bookRepository.findByBookIdAndCode(bookId,code);
        book.setIsDelete(StaticData.BOOK_DELETE_IS_DELETE);
        bookRepository.save(book);

    }

    //还书  需要精确到书 需要归还时的状态
    @Override
    public void giveBack(String userId,String code,String status)
    {
        Book book =bookRepository.findBookByCode(code);
        book.setState(StaticData.BOOK_STATUS_ALREADY_BACK);
        Borrow borrow = borrowRepository.findByUserIdAndCode(userId,code);
        if(borrow!=null)
        {
            borrow.setReturnStatus(status);
            borrowRepository.save(borrow);
        }
    }




    @Override
    public List<BookVo> findBookInfo(String bookId, String code, String state, String quality, Timestamp startTime, Timestamp endTime)
    {
//        return bookImp.findBookInfo(bookId,code,state,quality,startTime,endTime);
        return null;
    }

    @Override
    public List<BookVo> findBookInfo(String code, String name, String kind, String jiaofu, String type, String status, String quality, String author) {
        return bookImp.findBookInfo(code,name,kind,jiaofu,type,status,quality,author);

    }

    @Override
    public List<BookMsgVo> findBookMsgInfo(String bookId, String bookName, String jiaofu, String type, String publisher, String author) {
        return bookImp.findBookMsgInfo( bookId, bookName, jiaofu, type, publisher, author);
    }

    @Override
    public BookInfo FindBookInfoByCode(String code) {
        return bookImp.findBookInfoByCode(code);
    }

    @Override
    public List<BookMsgVo> findAllBookMsgInfo() {
        return null;
    }

    @Override
    public String findBookCodeByBookId(String bookId) {
        return bookImp.findBookCodeByBookId(bookId);
    }


}
