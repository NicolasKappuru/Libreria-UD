function cambiarFormulario() {
    const tipo = document.getElementById("tipo").value;
    const formulario = document.getElementById("formulario");
    let contenido = "";
    
    if (tipo === "libro") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date'></div>
            <div class='campo'><label>Autores:</label><input type='text'></div>
            <div class='campo'><label>Editorial:</label><input type='text'></div>
            <div class='campo'><label>ISBN:</label><input type='text'></div>
            <div class='campo'><label>Número de Páginas:</label><input type='number'></div>
        `;
    } else if (tipo === "articulo") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date'></div>
            <div class='campo'><label>Autores:</label><input type='text'></div>
            <div class='campo'><label>Editorial:</label><input type='text'></div>
            <div class='campo'><label>SSN:</label><input type='text'></div>
        `;
    } else if (tipo === "ponencia") {
        contenido = `
            <div class='campo'><label>Título:</label><input type='text'></div>
            <div class='campo'><label>Fecha de Publicación:</label><input type='date'></div>
            <div class='campo'><label>Autores:</label><input type='text'></div>
            <div class='campo'><label>Editorial:</label><input type='text'></div>
            <div class='campo'><label>Congreso:</label><input type='text'></div>
            <div class='campo'><label>SSN:</label><input type='text'></div>
        `;
    }
    formulario.innerHTML = contenido;
}

cambiarFormulario(); // Cargar formulario inicial