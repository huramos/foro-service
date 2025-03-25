package com.foro.controller;

import com.foro.DTO.CommentDTO;
import com.foro.model.Comment;
import com.foro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/topic/{topicId}")
    public List<CommentDTO> getCommentsByTopic(@PathVariable Long topicId) {
        return commentService.getCommentsByTopicId(topicId);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }
}