package cn.edu.hqu.library.Example.mapper;

import cn.edu.hqu.library.Example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepositroy extends JpaRepository<User,String> {
}
