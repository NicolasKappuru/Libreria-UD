document.addEventListener("DOMContentLoaded", function() {

    console.log(localStorage.getItem("token"));
    fetch('http://localhost:8080/Libreria/usuario/datos', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al obtener los datos del usuario');
        }
        return response.json();
    })
    .then(data => {
        insertarDato("nombre", data.nombre);
        insertarDato("correo", data.correo);
        insertarDato("direccion", data.direccion);
        insertarDato("telefono", data.telefono);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

function insertarDato(id, valor) {
    let elemento = document.getElementById(id);
    if (elemento) {
        let nuevoP = document.createElement("p");
        nuevoP.innerText = valor;
        elemento.parentNode.insertBefore(nuevoP, elemento.nextSibling);
    }
}
