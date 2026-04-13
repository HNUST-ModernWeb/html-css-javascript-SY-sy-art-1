package com.weibo;

import com.weibo.Post;
import com.weibo.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 微博控制层：提供微博相关接口，供前端调用
 */
@RestController
@RequestMapping("/api/weibo")
public class WeiboController {

    // 注入微博服务（业务逻辑）
    @Autowired
    private PostService postService;

    // 图片上传路径（和WebConfig中一致，无需修改）
    private final String uploadDir = "D:/weibo-upload/";

    // 发布微博接口：支持文字+图片上传
    @PostMapping("/publish")
    public String publish(
            @RequestParam String username,
            @RequestParam String content,
            @RequestParam(required = false) MultipartFile image
    ) throws IOException {
        // 1. 创建微博对象，设置基本信息
        System.out.println("username: " + username);
        Post post = new Post();
        post.setUsername(username);
        post.setContent(content);

        // 2. 处理图片上传（如果有图片）
        if (image != null && !image.isEmpty()) {
            // 创建上传目录（如果不存在）
            new File(uploadDir).mkdirs();
            // 生成唯一的图片文件名（避免重名）
            String imageName = UUID.randomUUID() + ".jpg";
            // 保存图片到本地目录
            image.transferTo(new File(uploadDir + imageName));
            // 设置图片访问路径（前端可通过该路径访问图片）
            post.setImageUrl("http://localhost:8080/upload/" + imageName);
        }

        // 3. 调用服务层，发布微博
        postService.publishPost(post);
        return "发布成功！";
    }

    // 获取所有微博接口：供首页展示
    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // 删除微博接口：只能删除自己发布的微博
    @DeleteMapping("/delete/{postId}")
    public boolean deletePost(
            @PathVariable Long postId,
            @RequestParam String username
    ) {
        return postService.deletePost(postId, username);
    }

    // 点赞接口：给指定微博点赞
//    @PostMapping("/like/{postId}")
//    public void likePost(@PathVariable Long postId) {
//        postService.likePost(postId);
//    }

    // 评论接口：给指定微博添加评论
    @PostMapping("/comment/{postId}")
    public void addComment(
            @PathVariable Long postId,
            @RequestParam String username,
            @RequestParam String content
    ) {
        postService.addComment(postId, username, content);
    }
}
