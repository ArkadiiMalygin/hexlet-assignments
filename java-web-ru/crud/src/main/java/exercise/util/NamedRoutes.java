package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() { return "/posts"; }

    public static String buildPostPath() { return "/posts/build"; }

    public static String postPath(long id) { return postPath(String.valueOf(id)); }

    public static String postPath(String id) { return "/posts/" + id; }
    // END
}
