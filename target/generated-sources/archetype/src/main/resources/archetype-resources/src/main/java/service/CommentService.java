#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.DTO.CommentDTO;
import ${package}.model.Comment;
import ${package}.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getCommentsByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findByTopicId(topicId);
        return comments.stream()
                      .map(comment -> new CommentDTO(
                          comment.getId(),
                          comment.getContent(),
                          comment.getUsername(),
                          comment.getCreatedAt()
                      ))
                      .collect(Collectors.toList());
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}