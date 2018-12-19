package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.mapper.AdviceImp;
import cn.edu.hqu.library.repository.AdviceRepository;
import cn.edu.hqu.library.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    AdviceRepository adviceRepository;
    @Autowired
    AdviceImp adviceImp;
    @Override
    public Object FindAllAdvice() {
        return adviceRepository.findAll();
    }

    @Override
    public Advice findAdviceByAdviceId(Integer adviceId) {
        return adviceRepository.findAdviceByAdviceId(adviceId);
    }

    @Override
    public void addAdvice(Advice advice) {
        adviceRepository.saveAndFlush(advice);
    }

    @Override
    public void DeleteByAdviceId(Integer adviceId) {
        adviceRepository.deleteById(adviceId);
    }

    @Override
    public List<Advice> findAdviceByConditions(Integer adviceId, String name,String advice,String state) {
        return adviceImp.findAdviceByConditions(adviceId,name,advice,state);
    }
}
