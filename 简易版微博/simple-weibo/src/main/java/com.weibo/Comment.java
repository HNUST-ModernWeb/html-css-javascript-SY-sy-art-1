package com.weibo;

public class Comment {
    private Long id;
    private String username;
    private String content;

    public Comment() {}
    public Comment(Long id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
    }

    // getter & setter
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}