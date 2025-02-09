function cambiarFormulario() {
    const tipo = document.getElementById("tipo").value;
    const formulario = document.getElementById("formulario");
    let contenido = "";
    
    if (tipo === "libro") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo' readonly></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha' readonly></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores' readonly></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial' readonly></div>
            <div class='campo'><label>ISBN:</label><input type='text' id='isbn' readonly></div>
            <div class='campo'><label>Número de Páginas:</label><input type='number' id='paginas' readonly></div>
        `;
    } else if (tipo === "articulo") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo' readonly></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha' readonly></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores' readonly></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial' readonly></div>
            <div class='campo'><label>SSN:</label><input type='text' id='ssn' readonly></div>
        `;
    } else if (tipo === "ponencia") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo' readonly></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha' readonly></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores' readonly></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial' readonly></div>
            <div class='campo'><label>Congreso:</label><input type='text' id='congreso' readonly></div>
            <div class='campo'><label>SSN:</label><input type='text' id='ssn' readonly></div>
        `;
    }

    contenido += `<button class="botonModificacionDocumento" onclick="window.location.href='../Documentos/formularioDoc.html'">Ir a Modificar</button>`;
    contenido += `<button class="botonReservaDocumento" onclick=reservarDocumento()">Reservar</button>`;
    formulario.innerHTML = contenido;
}


/*
IMPORTANTE: La funcionalidad de Modificar le quedó a la interfaz "frontend/Documentos/formularioDoc.html".
contenido += `<button class="botonModificacionDocumento" onclick="modificarDocumento()">Ir a Modificar</button>`;

function modificarDocumento() {
    const tipo = document.getElementById("tipo").value;
    const titulo = document.getElementById("titulo").value;
    const fecha = document.getElementById("fecha").value;
    const autores = document.getElementById("autores").value;
    const editorial = document.getElementById("editorial").value;
    const historial = document.getElementById("listaHistorial");

    let mensaje = `Modificación realizada - ${tipo.toUpperCase()} | Título: ${titulo}, Fecha: ${fecha}, Autores: ${autores}, Editorial: ${editorial}`;

    if (tipo === "libro") {
        const isbn = document.getElementById("isbn").value;
        const paginas = document.getElementById("paginas").value;
        mensaje += `, ISBN: ${isbn}, Páginas: ${paginas}`;
    } else if (tipo === "articulo") {
        const ssn = document.getElementById("ssn").value;
        mensaje += `, SSN: ${ssn}`;
    } else if (tipo === "ponencia") {
        const congreso = document.getElementById("congreso").value;
        const ssn = document.getElementById("ssn").value;
        mensaje += `, Congreso: ${congreso}, SSN: ${ssn}`;
    }

    const item = document.createElement("li");
    item.textContent = mensaje;
    historial.appendChild(item);
}
*/

function reservarDocumento() {
    // Lógica de reserva de Documento.
}

function recibirHistorialEventos() {
    // Lógica del historial de Eventos.
}

cambiarFormulario(); // Cargar formulario inicial