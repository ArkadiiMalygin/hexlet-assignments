@param exercise.dto.posts.PostsPage page

@template.layout.page(
page = page,
content = @`
    @for (var post : page.getPosts())
        <p>${post.toString()}</p>
    @endfor
`,
)
