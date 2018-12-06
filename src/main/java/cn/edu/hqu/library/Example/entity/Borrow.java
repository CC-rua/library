package cn.edu.hqu.library.Example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Borrow {

  private String userId;
  private String code;
  private java.sql.Timestamp btime;
  private java.sql.Timestamp etime;
  private String jiaofu;


}
