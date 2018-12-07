package cn.edu.hqu.library.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.classfile.Code;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookInfo {
   String Code;
   String name;
   String JiaoFu;
   String Kind;
   Date Btime;
   Date Etime;
}