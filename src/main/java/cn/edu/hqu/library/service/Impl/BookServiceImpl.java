package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.mapper.BookImp;
import cn.edu.hqu.library.repository.BorrowRepository;
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

    @Autowired
    public BookServiceImpl(BorrowRepository borrowRepository, BookImp bookImp) {
        this.borrowRepository = borrowRepository;
        this.bookImp = bookImp;
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
}
