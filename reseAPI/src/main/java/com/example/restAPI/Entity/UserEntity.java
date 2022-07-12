package com.example.restAPI.Entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
public class UserEntity {
    @Id @GeneratedValue

    private Long id;
    @NotNull
    @Email(message = "이메일 형식을 입력해주세요")
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String allergy;

    public UserEntity(){
    }

    public UserEntity(String email, String password, String name, String allergy) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.allergy = allergy;
    }
}
