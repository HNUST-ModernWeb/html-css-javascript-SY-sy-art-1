package com.weibo.service;

import com.weibo.entity.Comment;
import com.weibo.entity.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {
    private final List<Post> postList = new ArrayList<>();
    private Long postId = 1L;
    private Long commentId = 1L;

    // 发布微博
    public void publishPost(Post post) {
        post.setId(postId++);
        postList.add(0, post);
    }

    // 获取全部
    public List<Post> getAllPosts() {
        return postList;
    }

    // 删除微博（修复遍历删除异常）
    public boolean deletePost(Long postId, String username) {
        Iterator<Post> iterator = postList.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId().equals(postId) && post.getUsername().equals(username)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // 点赞去重（修复无限点赞）
    public boolean likePost(Long postId, String username) {
        for (Post post : postList) {
            if (post.getId().equals(postId)) {
                if (!post.getLikeUserList().contains(username)) {
                    post.getLikeUserList().add(username);
                    post.setLikeCount(post.getLikeCount() + 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // 评论判空
    public String addComment(Long postId, String username, String content) {
        if (content == null || content.trim().isEmpty()) return "评论不能为空";
        for (Post post : postList) {
            if (post.getId().equals(postId)) {
                Comment comment = new Comment(commentId++, username, content.trim());
                post.getComments().add(comment);
                return "评论成功";
            }
        }
        return "微博不存在";
    }
}