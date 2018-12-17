package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="advice")
public class Advice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long adviceId;
  private String userId;
  private String name;
  private String advice;


}
