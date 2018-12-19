package cn.edu.hqu.library.service;

import cn.edu.hqu.library.entity.Advice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdviceService {

    Object FindAllAdvice();

    Advice findAdviceByAdviceId(Integer adviceId);

    void addAdvice(Advice advice1);

    void DeleteByAdviceId(Integer AdviceId);

    List<Advice> findAdviceByConditions(Integer adviceId,String name, String advice,String state);
}
