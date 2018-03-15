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
                Formulario de Registro
                <br />
                <small>Clientes</small>
            </h1>
        </header>
        <section>
            <strong> <i class="fa fa-user"></i> Datos de Cliente</strong>
            <form method="POST" action="register" enctype="application/x-www-form-urlencoded">
                <div class="box">
                    <aside>
                        <label for="">
                            Nombres
                            <input type="text" name="nameClient" REQUIRED>
                        </label>
                    </aside>
                    <aside>
                        <label for="">
                            Apellidos
                            <input type="text" name="lastnameClient" REQUIRED>
                        </label>
                    </aside>
                    <aside>
                        <label for="">
                            Fecha Nacimiento
                            <input type="date" name="birthClient" data-date="" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" REQUIRED>
                        </label>
                    </aside>
                </div>
                <div class="box">
                    <article>
                        <p>
                            <strong>Correos por Cliente</strong>
                            <button type="button" id="add">
                                <i class="fa fa-plus"></i>
                                <span>Agregar</span>
                            </button>
                        </p>
                        <section id="mails"></section>
                    </article>
                </div>
                <div class="box">
                    <button type="reset" name="clear">
                        <i class="fa fa-trash"></i>
                        <span>Limpiar</span>
                    </button>
                    <button type="submit" name="register">
                        <i class="fa fa-save"></i>
                        <span>Registrar Cliente</span>
                    </button>
                </div>
            </form>
        </section>
    </main>
    <!-- block Scripts -->
    <script defer src="/resources/bundle.js"></script>
</body>
</html>