package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId()).stream()
                .map(c -> {
                    var comDto = new CommentDTO();
                    comDto.setId(c.getId());
                    comDto.setBody(c.getBody());
                    return comDto;
                })
                .toList();
        dto.setComments(comments);
        return dto;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var res = posts.stream()
                .map(this::toDTO)
                .toList();
        return res;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var dto = toDTO(post);
        return dto;
    }
}
// END
