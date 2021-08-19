package com.example.email_practice.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity //user class를 통해서 entity 읽어서 mysql 에 생성
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id //primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id; //sequence, auto-increment

  @Column(nullable = false, length = 100) // 해쉬 암호화
  private String password;

  @CreationTimestamp //시간자동 입력
  private Timestamp createDate;
}
