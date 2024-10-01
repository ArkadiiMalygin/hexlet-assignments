package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


// BEGIN
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private int page;
}
// END


