package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.repository.BorrowRepository;
import cn.edu.hqu.library.repository.zx.BookMsgRepository;
import cn.edu.hqu.library.repository.zx.BookRepository;
import cn.edu.hqu.library.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMsgRepository bookMsgRepository;

    @Autowired
    BorrowRepository borrowRepository;

    //返回取书代码
    public String UserBorrowSomeBook(String userId,String bookMsgId)
        {//需要去数据库找一本书 满足要求 并且质量较好
            Book book = bookRepository.findTop1ByBookIdOrderByQuality(bookMsgId);
            Bookmessage bookmessage = bookMsgRepository.findBookmessageByBookId(book.getBookId());
        //将信息放入借阅记录中
            Date now = new Date(System.currentTimeMillis());
            Date etime = new Date(System.currentTimeMillis()+1000*60*60*24* StaticData.JIEYUEQI);
            Borrow borrow = new Borrow(userId,book.getCode(),now,etime,bookmessage.getJiaofu(),book.getQuality(),null);
            borrowRepository.save(borrow);
//            book.setState(StaticData.BOOK_STATUS_WAIT_BACK);

            return book.getCode();
    }

    public void postponeBook(String userId,String code)
    {
        Borrow borrowMsg = borrowRepository.findByUserIdAndCode(userId,code);
        borrowMsg.setEtime(new Date(borrowMsg.getEtime().getTime()+1000*60*60*24*StaticData.POSTPONE_TIME));
        borrowRepository.saveAndFlush(borrowMsg);
    }

}
