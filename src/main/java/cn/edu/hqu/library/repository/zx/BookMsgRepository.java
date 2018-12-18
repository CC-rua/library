package cn.edu.hqu.library.repository.zx;

import cn.edu.hqu.library.entity.Bookmessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookMsgRepository extends JpaRepository<Bookmessage,String> {

    Bookmessage findBookmessageByBookId(String bookId);

    List<Bookmessage> findBookmessageByBookIdAndNameLikeAndJiaofuAndKindAndPublisherLikeAndAuthorLike(String bookId,String name,String jiaofu,String kind,String publisher,String author);


}
