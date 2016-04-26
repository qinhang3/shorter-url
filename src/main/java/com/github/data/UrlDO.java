package com.github.data;

import javax.persistence.*;

/**
 * Created by hang on 16/4/24.
 */
@Entity
@Table(name = "url")
public class UrlDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String hashCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public UrlDO(String url) {
        this.url = url;
        this.hashCode = String.valueOf(url.hashCode());
    }

    @Override
    public String toString() {
        return "UrlDO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", hashCode='" + hashCode + '\'' +
                '}';
    }

    public UrlDO() {
    }
}
