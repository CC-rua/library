package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Book;
import cn.edu.hqu.library.entity.Bookmessage;
import cn.edu.hqu.library.repository.zx.BookMsgRepository;
import cn.edu.hqu.library.repository.zx.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManagementService {

    @Autowired
    BookMsgRepository bookMsgRepository;

    @Autowired
    BookRepository bookRepository;

    public void addBookMsg(Bookmessage bookmessage)
    {
        bookMsgRepository.save(bookmessage);
    }

    public void updateBookMsg(Bookmessage bookmessage)
    {
        bookMsgRepository.saveAndFlush(bookmessage);
    }

    public void deleteBookMsg(Bookmessage bookmessage)
    {
        bookMsgRepository.delete(bookmessage);
    }

    public List<Bookmessage> findBookMsg(String bookId,String bookName,String jiaofu,String kind,String publisher,String author)
    {
        //bookMsgRepository.findBookmessageByBookIdAndNameLikeAndJiaofuAndKindAndPublisherLikeAndAuthorLike()
        return null;
    }

    public Bookmessage findBookMsgByBookId(String bookId)
    {
        return bookMsgRepository.findBookmessageByBookId(bookId);
    }


}
