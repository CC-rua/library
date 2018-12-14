package cn.edu.hqu.library.entity;

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


@Id
@Column(name = "BookID")
  private String bookId;
  private String name;
  private String jiaofu;
  private String kind;
  private String author;
  private String publisher;
  private String introduction;
}
