package com.example.woc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 03:54
 **/
//Lombok的注解
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_user")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;


}
