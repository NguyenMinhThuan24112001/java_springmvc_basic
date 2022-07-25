package com.learnSpringMVC.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createddate")
    @CreatedDate// thuộc tính năng Jpa Auditing
    private Date createdDate;

    @Column(name = "modifieddate")
    @LastModifiedDate //thuộc tính năng Jpa Auditing
    private Date modifiedDate;

    @Column(name = "createdby")
    @CreatedBy //thuộc tính năng Jpa Auditing
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy //thuộc tính năng Jpa Auditing
    private String modifiedBy;
}
