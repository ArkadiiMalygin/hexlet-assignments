@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
content = @`
    <h1>Users</h1>
    @if(page.getUsers().isEmpty())
        <p>No users</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
                <p>${user.toString()}</p>
            </div>
        @endfor
    @endif
`, footer = @`
    <p>I'll be here if u ever need me<p>
`
)