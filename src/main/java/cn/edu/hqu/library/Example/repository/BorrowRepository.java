package cn.edu.hqu.library.Example.repository;

import cn.edu.hqu.library.Example.entity.Book;

import cn.edu.hqu.library.Example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.RepositoryQuery;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow,String> {
    List<Borrow> findAllByUserId(String bookId);
}
