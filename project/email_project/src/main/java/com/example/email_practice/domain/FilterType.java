package com.example.email_practice.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilterType {

  private int categoryId;
  private String keyword;
  private Date fromdate;
  private Date todate;
  private String type;
  private String sort;
}
