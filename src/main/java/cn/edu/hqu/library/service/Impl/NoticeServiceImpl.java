package cn.edu.hqu.library.service.Impl;

import cn.edu.hqu.library.entity.Notice;
import cn.edu.hqu.library.mapper.NoticeImp;
import cn.edu.hqu.library.repository.NoticeRepository;
import cn.edu.hqu.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeImp noticeImp;
    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> FindAllNotice() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice findNoticeByNoticeId(String noticeId) {
        return noticeRepository.findNoticeByNoticeId(noticeId);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeRepository.saveAndFlush(notice);
    }

    @Override
    public void DeleteByNoticeId(String noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    @Override
    public List<Notice> findNoticeByConditions(String noticeId, String msg) {
        return noticeImp.findNoticeByConditions(noticeId,msg);
    }
}
