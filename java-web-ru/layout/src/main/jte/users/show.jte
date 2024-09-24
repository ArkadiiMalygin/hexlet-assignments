@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
        <h1>${page.getUser().getFirstName()}</h1>
        <p>${page.getUser().toString()}</p>
`, footer = @`
        <p>I'll be here if u ever need me<p>
`
)

