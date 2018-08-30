<html>
<head>
    <title>Home</title>
</head>
<body style="background-color: white;">
<h1  style="float: center; font-family: Arial">Tarea 2 </h1>
<ul style="list-style-type: none; margin: 0; padding: 0; overflow: hidden; background-color: gray;">
    <li style="float: left; font-family: Arial;"><a href="/" style="display: block; color: black; text-align: center; padding: 14px 16px; text-decoration: none;">Inicio</a></li>
    <li style="float: left; font-family: Arial;"><a href="/insert" style="display: block; color: black; text-align: center; padding: 14px 16px; text-decoration: none;">Nuevo Estudiante</a></li>
</ul>
</br>
<table  border="2" style="background: gray;" cellpadding="10">
    <thead>
    <tr>
        <th style="color: black;">Matrícula</th>
        <th style="color: black;">Nombre</th>
        <th style="color: black;">Apellidos</th>
        <th style="color: black;">Teléfono</th>
        <th style="color: black;">Editar</th>
        <th style="color: black;">Borrar</th>
        <th style="color: black;">Ver</th>
    </tr>
    </thead>
    <tbody >
            <#list lista as estudiante>
            <tr style="background: white; padding: 2px;">
                <td>${estudiante.matricula?c} </td>
                <td>${estudiante.nombre} </td>
                <td>${estudiante.apellido} </td>
                <td>${estudiante.telefono} </td>
                <td><a href="/update/${estudiante.matricula?c}" role="button">Editar</a></td>
                <td><a href="/deletefromlist/${estudiante.matricula?c}" role="button">Borrar</a></td>
                <td><a href="/ver/${estudiante.matricula?c}" role="button">Ver</a></td>
            </tr>
            </#list>
    </tbody>

</table>
</body>
</html>