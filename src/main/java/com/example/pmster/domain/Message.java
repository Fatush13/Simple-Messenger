package com.example.pmster.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please type in your message")      //must be not null and the trimmed length must be greater than zero
    @Length(max = 2048, message = "Message is too long(>2048)")
    private String text;
    @Length(max = 255, message = "Message is too long (>255)")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)     //indicates that author corresponds to multiple messages
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
    }    //empty constructor for @Entity

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
