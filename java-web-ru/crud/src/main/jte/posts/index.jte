@import exercise.model.Post
@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage

@param PostsPage page


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <a href="${NamedRoutes.postsPath()}">Все посты</a>
        </main>
    </div>
    <div>
        <table class="table table-striped">
        @for (Post post : page.getPosts())
        <tr>
            <td>
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </td>
            <td>
                ${post.getId()}
            </td>
            <td>
                ${post.getBody()}
            </td>
        </tr>
        @endfor
        </table>
    </div>
    <div>
        <a href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">next</a>
    </div>
    <div>
        <a href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">previous</a>
    </div>
`
)