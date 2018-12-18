package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Advice;
import cn.edu.hqu.library.repository.AdviceRepository;
import cn.edu.hqu.library.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    AdviceRepository adviceRepository;

}
