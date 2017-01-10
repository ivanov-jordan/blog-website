package com.blog.website.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "comments")
@Data
@EqualsAndHashCode(of = "id")
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String comment;
    private Date published;
    @JoinColumn(name = "articleid")
    @ManyToOne
    private Article article;
    @JoinColumn(name = "userid")
    @ManyToOne
    private User user;

}
