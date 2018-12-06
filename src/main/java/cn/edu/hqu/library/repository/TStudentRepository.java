package cn.edu.hqu.library.repository;

import cn.edu.hqu.library.entity.TStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TStudentRepository extends JpaRepository<TStudent,String> {
    List<TStudent> findAllByXsxh(String xsxh);
}
