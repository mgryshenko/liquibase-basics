package com.mgryshenko.liquibasetest.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    public static Message fromContent(String author, String content) {
        Message message = new Message();
        message.setAuthor(author);
        message.setContent(content);
        message.setCreated(new Date());
        message.setUpdated(new Date());
        return message;
    }
}
