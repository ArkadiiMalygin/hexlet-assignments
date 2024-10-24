
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
                Выйти
                <input type="submit" value="Выйти"/>
            </form>
        </div>
    @else
        <div class="center">
            <form action="${NamedRoutes.buildSessionPath()}" method="get">
                Войти
                <input type="submit" value="Войти"/>
            </form>
        </div>
    @endif
`
)