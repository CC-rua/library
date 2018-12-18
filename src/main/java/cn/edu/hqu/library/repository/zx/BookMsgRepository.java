package cn.edu.hqu.library.repository.zx;

import cn.edu.hqu.library.entity.Bookmessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMsgRepository extends JpaRepository<Bookmessage,String> {

    Bookmessage findBookmessageByBookId(String bookId);

}
