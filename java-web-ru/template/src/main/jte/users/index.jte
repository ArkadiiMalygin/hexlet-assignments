@import exercise.dto.users.UsersPage
@param UsersPage usersPage


<html lang="en">
<head>
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
@if(usersPage.getUsers().isEmpty())
    <p>No users</p>
@else
    @for(var user : usersPage.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.toString()}</p>
        </div>
    @endfor
@endif
</body>
</html>