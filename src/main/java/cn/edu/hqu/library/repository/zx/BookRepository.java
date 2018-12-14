package cn.edu.hqu.library.repository.zx;

import cn.edu.hqu.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {

//    List<Book> findBy(Timestamp time);

    /**
     * 	//查询按照时间顺序入库的三本书
     * 	<select id="findAllByPutawayTime" resultType="cn.edu.hqu.library.controller.vo.NewBookInfo">
     * 		SELECT name , author , publisher , introduction
     * 		FROM Library.book left join bookmessage ON book.BookID = bookmessage.BookID;
     * 		ORDER by book.putawayTime DESC
     * 		limit 0,10
     * 	</select>
     */

}
