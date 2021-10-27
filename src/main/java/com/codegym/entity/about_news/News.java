package com.codegym.entity.about_news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsId;
    private String newsTitle;
    private String newsBrief;
    @Column(columnDefinition = "varchar(5000)")
    private String newsContent;
    private String imageUrl;
    private Date postDate;

    @ManyToOne(targetEntity = Type.class)
    @JsonBackReference
    @JoinColumn(name = "type_id", referencedColumnName = "typeId")
    private Type type;

    public News() {
    }

    public News(Integer newsId, String newTitle, String newsBrief, String newsContent, String imageUrl, Date postDate, Type type) {
        this.newsId = newsId;
        this.newsTitle = newTitle;
        this.newsBrief = newsBrief;
        this.newsContent = newsContent;
        this.imageUrl = imageUrl;
        this.postDate = postDate;
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewTitle() {
        return newsTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newsTitle = newTitle;
    }

    public String getNewsBrief() {
        return newsBrief;
    }

    public void setNewsBrief(String newsBrief) {
        this.newsBrief = newsBrief;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
