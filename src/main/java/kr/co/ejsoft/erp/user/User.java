package kr.co.ejsoft.erp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
  @Id
  @GeneratedValue
  public int id;

  @Column
  public String name;

  @Column
  public String email;

  @Column
  public String password;
}
