package com.therogueroad.project.controllers;

import com.therogueroad.project.dto.CommentDTO;
import com.therogueroad.project.dto.PostDTO;
import com.therogueroad.project.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comments/posts/{postId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @PostMapping("/comments/reply/{commentId}")
    public ResponseEntity<CommentDTO> createCommentReply(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createCommentReply(commentId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.FOUND);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDTO> findCommentById(@PathVariable Long commentId){
        return new ResponseEntity<>(commentService.findComment(commentId), HttpStatus.FOUND);
    }
}
