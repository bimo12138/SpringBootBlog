package com.bimo.bimo.pojo;

/*
 * @fileName: functions
 * @author  : 13716
 * @Date    : 2020-07-14 17:27
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "functions")
public class Functions {
    @Id
    @GenericGenerator(name = "uuidGenerate", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerate")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public Functions(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Functions() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
