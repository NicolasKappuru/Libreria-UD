const form = document.getElementById('formDoc');
let iddocumento = "";
let valoresIniciales = {};

function obtenerValores() {
    return {
        tipo: document.getElementById("tipoDocumento").value,
        titulo: document.getElementById("titulo").value,
        fechaPublicacion: document.getElementById("fechaPublicacion").value,
        autores: document.getElementById("autores").value,
        editorial: document.getElementById("editorial").value,
        isbn: document.getElementById("isbn").value,
        numPaginas: document.getElementById("numPaginas").value,
        nombreCongreso: document.getElementById("nombreCongreso").value,
        ssn: document.getElementById("ssn").value
    };
}

function haCambiado() {
    const valoresActuales = obtenerValores();
    return Object.keys(valoresIniciales).some(key => valoresIniciales[key] !== valoresActuales[key]);
}

function guardarValoresIniciales() {
    valoresIniciales = obtenerValores();
}

document.getElementById("submitBtn").addEventListener("click", function(event) {
    event.preventDefault();
    
    if (haCambiado()) {
        guardarValoresIniciales();
        if (iddocumento === "") {
            crear();
        } else {
            modificar();
        }
    }
});

function crear()  {

    const formData = new FormData(form);
    const data = {
        iddocumento: iddocumento,
        tipo: document.getElementById("tipoDocumento").value,
        titulo: formData.get('titulo'),
        fechaPublicacion: formData.get('fechaPublicacion'),
        autores: formData.get("autores"),
        editorial: formData.get("editorial"),
        isbn: formData.get("isbn"),
        numPaginas: formData.get("numPaginas"),
        nombreCongreso: formData.get("nombreCongreso"),
        ssn: formData.get("ssn")
    };

    fetch('http://localhost:8080/Libreria/documento/crear', {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al obtener los datos del usuario');
        }
        return response.json();
    })
    .then(data => {
        iddocumento = data.mensaje;
    })
    .catch(error => {
        console.error('Error:', error);
    });
    
};

function modificar(){
    const formData = new FormData(form);
    const data = {
        iddocumento: iddocumento,
        tipo: document.getElementById("tipoDocumento").value,
        titulo: formData.get('titulo'),
        fechaPublicacion: formData.get('fechaPublicacion'),
        autores: formData.get("autores"),
        editorial: formData.get("editorial"),
        isbn: formData.get("isbn"),
        numPaginas: formData.get("numPaginas"),
        nombreCongreso: formData.get("nombreCongreso"),
        ssn: formData.get("ssn")
    };

    fetch('http://localhost:8080/Libreria/documento/modificar', {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al obtener los datos del usuario');
        }
        return response.json();
    })
    .then(data => {
        console.log(data.mensaje);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

document.addEventListener("DOMContentLoaded", () => {
    const inputs = document.querySelectorAll("#formDoc input, #formDoc button");
    inputs.forEach(input => input.disabled = true);
    document.getElementById("tipoDocumento").disabled = false;
});

function activarCampos(){
    let tipoDocumento = document.getElementById("tipoDocumento").value;

    if (tipoDocumento) {
        document.getElementById("tipoDocumento").disabled = true; // Bloquear el select

        document.querySelectorAll("#formDoc input").forEach(input => {
            input.disabled = false;

           
        });

        document.getElementById("submitBtn").disabled = false;

        // Mostrar y habilitar solo los campos necesarios
        document.getElementById("campoISBN").style.display = (tipoDocumento === "libro" || tipoDocumento === "ponencia") ? "block" : "none";
        document.getElementById("isbn").disabled = !(tipoDocumento === "libro" || tipoDocumento === "ponencia");

        document.getElementById("campoPaginas").style.display = (tipoDocumento === "libro") ? "block" : "none";
        document.getElementById("numPaginas").disabled = !(tipoDocumento === "libro");

        document.getElementById("campoCongreso").style.display = (tipoDocumento === "ponencia") ? "block" : "none";
        document.getElementById("nombreCongreso").disabled = !(tipoDocumento === "ponencia");

        document.getElementById("campoSSN").style.display = (tipoDocumento === "articulo") ? "block" : "none";
        document.getElementById("ssn").disabled = !(tipoDocumento === "articulo");
        
       
        document.querySelectorAll("#formDoc input").forEach(input => {
            input.addEventListener("blur", () => {
                if (haCambiado()) {
                    guardarValoresIniciales();
                    if (iddocumento === "") {
                        crear();
                    } else {
                        modificar();
                    }
                }
            });
        });
    }
}

guardarValoresIniciales();