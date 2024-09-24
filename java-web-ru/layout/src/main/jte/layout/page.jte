
@import gg.jte.Content


@param Content content = null
@param Content footer = null


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Users</title>
</head>
<body>
    <header>
        <a href="/users">Users</a>
        <a href="/">Home</a>
    </header>
    <main>
        @if (content != null)
            <div class="content">
                ${content}
            </div>
        @else
            <p>Welcome to users</p>
        @endif
    </main>
    <footer>
        @if (footer != null)
            <div class="footer">
                ${footer}
            </div>
        @endif
    </footer>
</body>
</html>
