@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
    @if(page != null)
        <div>
            <a>${page.getError()}</a>
        </div>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            Nickname
            <input type="text" placeholder="Nickname" name="nickname" />
        </label>
        <label>
            Password
            <input type="password" placeholder="Password" name="password" />
        </label>
        <input type="submit"/>
    </form>
`
)
