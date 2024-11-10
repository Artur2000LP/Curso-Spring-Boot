// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();
  $('#usuarios').DataTable();

  actualizarCorreoUsuario();

});

function actualizarCorreoUsuario(){
  document.getElementById("txt-correo-usuario").outerHTML = localStorage.email
}

async function cargarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: headers()

  });
  const usuarios = await request.json();

  console.log(usuarios)


  let listadoHtml = '';

  for(let usuario of usuarios){

    let botonEliminar = `
            <a href="#" onclick="eliminarUsuario(${usuario.id})" class="btn btn-danger btn-circle btn-sm">
                <i class="fas fa-trash"></i>
            </a>
    `;

    let usuariohtml = ` 
    <tr>
        <td>${usuario.id}</td>
        <td>${usuario.nombre} ${usuario.apellido}</td>
        <td>${usuario.correo}</td>
        <td>${usuario.telefono}</td>
        <td>${usuario.password}</td>
        <td>${usuario.edad}</td>
        <td>
           ${botonEliminar} 
        </td>
    </tr>
  `;

    listadoHtml += usuariohtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}


async function eliminarUsuario(id) {
  if(!confirm("¿desea eliminar este usuario?")){
    return;
  }
  const request = await fetch('api/usuarios/'+id, {
    method: 'DELETE',
    headers: headers()

  });

  location.reload();  // actualiza la paguina

}

function headers(){
  return   {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}