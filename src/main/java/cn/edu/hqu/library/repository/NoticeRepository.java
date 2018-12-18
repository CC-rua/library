package cn.edu.hqu.library.repository;

import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,String> {
    List<Notice> findAll();
    Notice findNoticeByNoticeId(String noticeId);
}
