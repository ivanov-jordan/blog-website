package com.blog.website.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean editor;

}
