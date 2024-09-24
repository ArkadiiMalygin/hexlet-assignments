package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var neededUsers = new ArrayList<>();
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            int i;
            int k;
            if (page == 1) {
                i = 0;
                k = per;
            } else {
                i = ((page - 1) * per) + 1;
                k = (page * per) + 1;
            }
            for (; i < k; i++) {
                neededUsers.add(USERS.get(i));
            }
            ctx.json(neededUsers);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
