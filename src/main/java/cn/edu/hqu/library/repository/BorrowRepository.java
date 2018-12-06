package cn.edu.hqu.library.repository;

import cn.edu.hqu.library.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow,String> {
    List<Borrow> findAllByUserId(String bookId);
}
