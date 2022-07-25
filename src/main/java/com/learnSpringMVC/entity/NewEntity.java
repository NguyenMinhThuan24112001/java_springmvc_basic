package com.learnSpringMVC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "newentity")
@Getter
@Setter
@AllArgsConstructor
public class NewEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "shortdescription")
    private String shortDescription;

    @Column(name = "content")
    private String content;


    public NewEntity() {

    }

//    @ManyToOne
//    @JoinColumn(name = "categoryId")
//    private CategoryEntity categoryEntity;
//
//    private String categoryCode;
}
