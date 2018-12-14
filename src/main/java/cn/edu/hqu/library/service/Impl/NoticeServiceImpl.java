package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.repository.NoticeRepository;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> FindAllNotice() {
        return noticeRepository.findAll();
    }
}
