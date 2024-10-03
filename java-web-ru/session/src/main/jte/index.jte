
@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        <div>
            <h1>Привет, Хекслет!</h1>
                Добро пожаловать ${page.getName().toString()}.
                Чтобы разлогиниться, удалите куку JSESSIONID из браузера
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="выйти"/>
            </form>
        </div>
    @else
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="войти"/>
        </form>
    @endif
`
)