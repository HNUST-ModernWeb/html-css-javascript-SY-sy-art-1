package com.weibo.entity;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private Long id;
    private String username;
    private String content;
    private String imageUrl;
    private int likeCount;
    // 记录点赞用户，实现去重
    private List<String> likeUserList = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Post() {
        this.likeCount = 0;
    }

    // getter & setter
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public int getLikeCount() {return likeCount;}
    public void setLikeCount(int likeCount) {this.likeCount = likeCount;}
    public List<String> getLikeUserList() {return likeUserList;}
    public void setLikeUserList(List<String> likeUserList) {this.likeUserList = likeUserList;}
    public List<Comment> getComments() {return comments;}
    public void setComments(List<Comment> comments) {this.comments = comments;}
}
