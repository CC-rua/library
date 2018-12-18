package cn.edu.hqu.library.repository;
import cn.edu.hqu.library.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserIdEqualsAndPasswordEquals(String name, String pwd);
    User findAllByUserIdEquals(String userId);
//    void deleteByUserName(String userName);
}
