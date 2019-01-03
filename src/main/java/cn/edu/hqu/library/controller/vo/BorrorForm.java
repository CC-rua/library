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

    private String status;

    private String quality;
    private String translateStatus(String status){
        switch (status){
            case "0":return "正常";
            case "1":return "尚未取书";
            case "2":return "延期";
            case "3":return "逾期未还";
            default:
                break;
        }
        return "";
    }
    private String translateQuality(String quality){
        switch (status){
            case "0":return "正常";
            case "1":return "严重缺损";
            default:
                break;
        }
        return "";
    }
    private String translateJiaoFu(String jiaofu){
//        if(jiaofu.equals("是")){
//            return "教辅类";
//        }else {
//            return "非教辅";
//        }
        return jiaofu;
    }
    public BorrorForm(BookInfo borrow) {
        this.name=borrow.getName();
        this.code = borrow.getCode();
        this.btime = DateTransferUtil.DateToLocalDate(borrow.getBtime());
        this.etime = DateTransferUtil.DateToLocalDate(borrow.getEtime());
        this.jiaofu = translateJiaoFu(borrow.getJiaoFu());
        this.status= translateStatus(borrow.getStatus());
        this.quality = translateQuality(borrow.getQuality());
    }
}
