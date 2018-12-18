package cn.edu.hqu.library.repository;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdviceRepository extends JpaRepository<Advice,Integer> {

}
