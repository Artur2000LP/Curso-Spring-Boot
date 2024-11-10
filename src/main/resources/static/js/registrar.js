async function registarUsuarios() {
    let datos = {};
    datos.nombre = document.getElementById("txtNombre").value;
    datos.apellido = document.getElementById("txtApellido").value;
    datos.correo = document.getElementById("txtCorreo").value;
    datos.password = document.getElementById("txtPassword").value;

    let repetirPassword = document.getElementById("txtRepetirPassword").value;


    if(repetirPassword !== datos.password){
        alert("Verificación de contraseña incorrecta");
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    console.log(datos);

    alert("Usuario registrado exitosamente");

}

