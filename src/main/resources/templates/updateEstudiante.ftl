<!DOCTYPE html>
<html>

<head>
    <title style="float: center;">Modificar lista.Estudiante</title>
</head>

<body style="background-color: white;">

<header >
    <h1 style="font-family: Arial;">Modificar estudiante</h1>
</header>

<nav >
    <div >
        <div >
            <ul style="list-style-type: none; margin: 0; padding: 0; overflow: hidden; background-color: gray;">
                <li style="float: left; font-family: Arial;">
                    <a  href="/" style="display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;">Inicio</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

        <div >

             <hr>
            <form method="post" action="/updateL">

                    <div >
                     <label for="matricula">Matricula</label>
                     <input type="text" id="matricula" name="matricula" value='${actual.matricula?c}' required>
                    </div>

                    <div>
                        <label for="nombre">Nombre</label>
                        <input type="text" id="nombre" name="nombre" value='${actual.nombre}' required>
                    </div>

                    <div>
                        <label for="apellido">Apellido</label>
                        <input type="text"  id="apellido" name="apellido" value='${actual.apellido}' required>
                    </div>

                    <div >
                        <label for="telefono">Teléfono</label>
                        <input type="text"  id="telefono" name="telefono" value='${actual.telefono}' required>
                    </div>

                <input type="submit" value="Modificar estudiante en la tabla">

            </form>
        </div>
    </body>
</html>