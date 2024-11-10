async function iniciarSecion() {
    let datos = {};
    datos.correo = document.getElementById("txtEmail").value;
    datos.password = document.getElementById("txtPassword").value;


    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    console.log(datos);
    // const respuesta = await request.json();
    const respuesta = await request.text();

    if(respuesta !== "error"){
        localStorage.token = respuesta;
        localStorage.email = datos.correo;
        window.location.href = 'usuarios.html';
    }else{
        alert("las credenciales son Incorrectos ")
    }

}

