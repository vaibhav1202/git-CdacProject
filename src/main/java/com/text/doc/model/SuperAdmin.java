
package com.text.doc.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SuperAdmin")
//@SequenceGenerator(name="id", initialValue=1, allocationSize=1)
@EntityListeners(AuditingEntityListener.class)
public class SuperAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "pass_word", nullable = false)
    private String password;

    @Column(name = "email_address", nullable = false)
    private String email;
    

  public long getId() {
        return id;
    }


  public void setId(long id) {
        this.id = id;
    }

  public String getFirstName() {
        return firstName;
    }


  public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

 
  public String getLastName() {
        return lastName;
    }

 
  public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  public String getPass() {
      return password;
  }


public void setPass(String password) {
      this.password = password;
  }

  public String getEmail() {
        return email;
    }

  public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "SuperAdmin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +     
                '}';
    }


}
