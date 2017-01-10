package com.blog.website.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Data
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    // @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    // private List<Article> articles;

}
