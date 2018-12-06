package cn.edu.hqu.library.Example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bookmessage {

  private String bookId;
  private String name;
  private String jiaofu;
  private String kind;


}
