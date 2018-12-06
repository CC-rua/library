package cn.edu.hqu.library.Example.service;

import cn.edu.hqu.library.Example.entity.Example;
import cn.edu.hqu.library.Example.entity.User;
import cn.edu.hqu.library.Example.mapper.ExampleImp;
import cn.edu.hqu.library.Example.mapper.ExampleRepositroy;
import cn.edu.hqu.library.Example.mapper.ExampleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService implements ExampleServiceImp {
    private final
    ExampleRepositroy exampleRepositroy;

    @Autowired
    public ExampleService(ExampleRepositroy exampleRepositroy) {
        this.exampleRepositroy = exampleRepositroy;
    }
    public void AddFakeDate() {
        for(int i=0;i<10;i++){
            User user=new User();
            user.setUserId("1625122"+i);
            user.setPasswd(""+i);
            user.setType("1");
            exampleRepositroy.save(user);
        }
    }
}
