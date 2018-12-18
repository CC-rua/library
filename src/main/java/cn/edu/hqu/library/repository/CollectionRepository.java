package cn.edu.hqu.library.repository;

import cn.edu.hqu.library.entity.Collection;
import cn.edu.hqu.library.entity.UnionKey.BorrowKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, BorrowKey> {



}
