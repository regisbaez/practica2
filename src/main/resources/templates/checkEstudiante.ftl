<!DOCTYPE html>
<html >
<head>
    <title>Check lista.Estudiante</title>
</head>
<body style="background-color: white;">
<header >
    <h1 style="float: center; font-family: Arial;">Ver estudiante</h1>
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
    <div >
        <div >
            <ul >
                <li style="font-family: Arial"><span > <strong> Matricula:</strong> </span>${actual.matricula?c}</li>
                <li style="font-family: Arial"><span > <strong> Nombre: </strong> </span>${actual.nombre}</li>
                <li style="font-family: Arial"><span > <strong> Apellido:</strong> </span>${actual.apellido}</li>
                <li style="font-family: Arial"><span > <strong> Teléfono: </strong></span>${actual.telefono}</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>