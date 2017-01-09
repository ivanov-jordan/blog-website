package com.blog.website.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "articles")
@Data
@EqualsAndHashCode(of = "id")
public class Article {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String content;
    private String image;
    private Date published;

    @JoinColumn(name = "author")
    @ManyToOne
    private User author;

    @JoinTable(name = "categories_articles",
            joinColumns = {@JoinColumn(name = "articleid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "categoryid", referencedColumnName = "id")})
    @ManyToMany
    private List<Category> categories;

}
