package cn.edu.hqu.library.Example.service.Impl;

import cn.edu.hqu.library.Example.entity.Borrow;
import cn.edu.hqu.library.Example.repository.BorrowRepository;
import cn.edu.hqu.library.Example.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public List<Borrow> borrowInfo(String userId) {
        return borrowRepository.findAllByUserId(userId);
    }
}
