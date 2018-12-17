package cn.edu.hqu.library.repository;
import cn.edu.hqu.library.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserIdEqualsAndPasswordEquals(String name, String pwd);
    User findAllByUserIdEquals(String name);

//    void deleteByUserName(String userName);
}
