package com.bimo.bimo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "article")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Article implements Serializable {

    @Id
    @GenericGenerator(name = "uuidGenerate", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerate")
    private String id;

    @Column(name = "title", length = 32)
    private String title;

    @Column(name = "content", length = 10000)
    private String content;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_time;

    @Column(name = "last_edit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_edit_time;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getLast_edit_time() {
        return last_edit_time;
    }

    public void setLast_edit_time(Date last_edit_time) {
        this.last_edit_time = last_edit_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article() {
    }

    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.start_time = new Date();
        this.last_edit_time = this.start_time;
        this.user = user;
    }

}
