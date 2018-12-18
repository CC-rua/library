package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.controller.vo.NewBookInfo;
import cn.edu.hqu.library.controller.vo.RecommendBookInfo;
import cn.edu.hqu.library.controller.zx.vo.BookMsgVo;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.mapper.BookImp;
import cn.edu.hqu.library.repository.BorrowRepository;
import cn.edu.hqu.library.repository.zx.BookMsgRepository;
import cn.edu.hqu.library.repository.zx.BookRepository;
import cn.edu.hqu.library.service.BookService;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.service.dto.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
