package cn.edu.hqu.library.controller.vo;

import cn.edu.hqu.library.entity.Borrow;
import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.util.DateTransferUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrorForm {


    private String name;
    private String code;

    private LocalDate btime;

    private LocalDate etime;

    private String jiaofu;

    public BorrorForm(BookInfo borrow) {
        this.name=borrow.getName();
        this.code = borrow.getCode();
        this.btime = DateTransferUtil.DateToLocalDate(borrow.getBtime());
        this.etime = DateTransferUtil.DateToLocalDate(borrow.getEtime());
        this.jiaofu = borrow.getJiaoFu();
    }

}
