package cn.edu.hqu.library.repository;
import cn.edu.hqu.library.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameEqualsAndPasswordEquals(String name, String pwd);
    User findAllByUsernameEquals(String name);

//    void deleteByUserName(String userName);
}
