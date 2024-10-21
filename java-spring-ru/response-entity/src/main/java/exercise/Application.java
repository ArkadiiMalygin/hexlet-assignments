package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "10") Integer limit) {
        var result = posts.stream().limit(limit).toList();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(result);
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Post> show(@PathVariable String id) {
        var post = posts.stream().filter(p -> p.getId().equals(id)).findFirst();

        return ResponseEntity.of(post);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> put(@RequestBody Post postData) {
        posts.add(postData);
        var post = posts.stream().filter(p -> p.getId().equals(postData.getId())).findFirst();
        return new ResponseEntity<>(post.get(), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@RequestBody Post postData, @PathVariable String id) {
        var post = posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (post.isPresent()) {
            var res = post.get();
            res.setId(postData.getId());
            res.setTitle(postData.getTitle());
            res.setBody(postData.getBody());
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);


    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
