package cn.edu.hqu.library.service;

import cn.edu.hqu.library.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> FindAllNotice();

    Notice findNoticeByNoticeId(String noticeId);

    void addNotice(Notice notice);

    void DeleteByNoticeId(String noticeId);

    List<Notice> findNoticeByConditions(String noticeId, String msg);
}
