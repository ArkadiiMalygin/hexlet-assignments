@param gg.jte.Content content
@param exercise.dto.BasePage page = null


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Hexlet Javalin Example</title>
</head>
<body>
@if(page != null && page.getFlash() != null)
    <p class="red">${page.getFlash()}</p>
@endif
${content}
</body>
</html>


