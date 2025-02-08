function cambiarFormulario() {
    const tipo = document.getElementById("tipo").value;
    const formulario = document.getElementById("formulario");
    let contenido = "";
    
    if (tipo === "libro") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha'></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores'></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial'></div>
            <div class='campo'><label>ISBN:</label><input type='text' id='isbn'></div>
            <div class='campo'><label>Número de Páginas:</label><input type='number' id='paginas'></div>
        `;
    } else if (tipo === "articulo") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha'></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores'></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial'></div>
            <div class='campo'><label>SSN:</label><input type='text' id='ssn'></div>
        `;
    } else if (tipo === "ponencia") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text' id='titulo'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date' id='fecha'></div>
            <div class='campo'><label>Autores:</label><input type='text' id='autores'></div>
            <div class='campo'><label>Editorial:</label><input type='text' id='editorial'></div>
            <div class='campo'><label>Congreso:</label><input type='text' id='congreso'></div>
            <div class='campo'><label>SSN:</label><input type='text' id='ssn'></div>
        `;
    }

    contenido += `<button class="botonModificacionDocumento" onclick="modificarDocumento()">Modificar</button>`;
    formulario.innerHTML = contenido;
}

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

cambiarFormulario(); // Cargar formulario inicial