@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage

@param PostPage page


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <a href="${NamedRoutes.postsPath()}">Все посты</a>
        </main>
    </div>
    <div>
        <table>
            <tr>
                ${page.getPost().getName()}
            </tr>
            <tr>
                ${page.getPost().getId()}
            </tr>
            <tr>
                ${page.getPost().getBody()}
            </tr>
        </table>
    </div>
`
)