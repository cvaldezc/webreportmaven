<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido::Registro</title>
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
</head>
<body>
    <main>
        <header>
            <h1>
                <i class="fa fa-remove"></i>
                <% if (request.getParameter("exception") == null) { %>
                Se ha producido un error
                <br />
                <small>registrar al Cliente</small>
                <% } else { %>
                    Se ha Producido un error!
                    <small><%= request.getParameter("exception"); %></small>
                <% } %>
            </h1>
        </header>
        <nav><a href="../"><< REGRESAR</a></nav>
    </main>
</body>
</html>