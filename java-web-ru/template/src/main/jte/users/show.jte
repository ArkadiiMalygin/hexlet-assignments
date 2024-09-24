@import exercise.dto.users.UserPage
@param UserPage userPage


<html lang="en">
<head>
    <title><a href="/users">users</a></title>
</head>
<body>
<main>
    <h1>${userPage.getUser().getFirstName()}${userPage.getUser().getLastName()}</h1>
    <p>${userPage.getUser().getEmail()}</p>
    <p>${userPage.getUser().getId()}</p>
</main>
</body>
</html>