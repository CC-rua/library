package cn.edu.hqu.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="advice")
public class Advice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adviceID")
  private Integer adviceId;
  @Column(name = "UserID")
  private String userId;
  @Column(name = "Name")
  private String name;
  @Column(name = "advice")
  private String advice;


}
