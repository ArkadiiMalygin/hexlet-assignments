package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;


import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        try {
            var nickname = ctx.formParamAsClass("nickname", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password.")
                    .get();
            var password = ctx.formParamAsClass("password", String.class)
                .check(value -> Security.encrypt(value)
                        .equals(UsersRepository.findByName(nickname).get().getPassword())
                        ,"Wrong username or password.")
                    .get();
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect("/");
        } catch (ValidationException e) {
            var nickname = ctx.formParam("nickname");
            var error = "Wrong username or password.";
            var page = new LoginPage(nickname, error);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");

    }
    // END
}
