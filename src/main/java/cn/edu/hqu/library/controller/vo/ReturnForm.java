package cn.edu.hqu.library.controller.vo;

import cn.edu.hqu.library.service.dto.BookInfo;
import cn.edu.hqu.library.util.DateTransferUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnForm {


    private String name;
    private String code;


    private String jiaofu;

    private String ReturnStatus;

    private String quality;
    private String translateReturnStatus(String ReturnStatus){
        switch (ReturnStatus){
            case "0":return "未归还";
            case "1":return "已归还";
            case "2":return "逾期归还";
            default:
                break;
        }
        return "";
    }
    private String translateQuality(String quality){
        switch (quality){
            case "0":return "正常";
            case "1":return "";
            case "2":return "";
            case "3":return "严重缺损";
            default:
                break;
        }
        return "";
    }
    private String translateJiaoFu(String jiaofu){
        if(jiaofu.equals("是")){
            return "教辅类";
        }else {
            return "非教辅";
        }
    }
    public ReturnForm(BookInfo borrow) {
        this.name=borrow.getName();
        this.code = borrow.getCode();
        this.jiaofu = translateJiaoFu(borrow.getJiaoFu());
        this.ReturnStatus= translateReturnStatus(borrow.getReturnStatus());
        this.quality = translateQuality(borrow.getQuality());
    }
}
