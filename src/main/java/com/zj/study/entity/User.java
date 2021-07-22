package com.zj.study.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Administrator
 */
@Table("user")
@Data
public  class User {
   @Id
   private String id;
   private String name;
   private Integer age;
   private String email;
   private Integer phoneNumber;

}