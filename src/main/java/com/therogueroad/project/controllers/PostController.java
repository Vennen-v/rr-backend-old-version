package com.therogueroad.project.controllers;

import com.therogueroad.project.dto.PostDTO;
import com.therogueroad.project.models.User;
import com.therogueroad.project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.FOUND);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long postId){
        return new ResponseEntity<>(postService.getPost(postId), HttpStatus.FOUND);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.FOUND);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<PostDTO> getPostBySearch(@RequestParam(name = "keyword") String keyword){
        return new ResponseEntity<>(postService.findByKeyword(keyword), HttpStatus.FOUND);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("Post Successfully Deleted", HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Long postId){
        return new ResponseEntity<>(postService.updatePost(postDTO, postId), HttpStatus.OK);
    }


    //Create Get Currents User's Post
}
