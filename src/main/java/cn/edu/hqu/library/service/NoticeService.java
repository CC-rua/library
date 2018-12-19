package cn.edu.hqu.library.service;

import cn.edu.hqu.library.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> FindAllNotice();

    Notice findNoticeByNoticeId(Integer noticeId);

    void addNotice(Notice notice);

    void DeleteByNoticeId(Integer noticeId);

    List<Notice> findNoticeByConditions(Integer noticeId, String msg);
}
