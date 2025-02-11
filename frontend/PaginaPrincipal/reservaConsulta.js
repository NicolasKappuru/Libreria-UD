function agregarReservas(nuevasReservas) {
    const tabla = document.getElementById("tabla-reservas");

    nuevasReservas.forEach(reserva => {
        let fila = document.createElement("tr");

        fila.innerHTML = `
            <td>${reserva.titulo}</td>
            <td>${reserva.tipo}</td>
            <td>${reserva.fecha_reserva}</td>
            <td>${reserva.fecha_entrega}</td>
            <td><button onclick="reservar('${reserva.titulo}')">Reservar</button></td>
        `;

        tabla.appendChild(fila);
    });
}

function reservar(titulo) {
    alert(`Has reservado el libro: ${titulo}`);
}

// Simulación de llegada de datos JSON
const nuevasReservas = [
    { titulo: "El Principito", tipo: "Libro", fecha_reserva: "2025-02-10", fecha_entrega: "2025-02-17" },
    { titulo: "Cien Años de Soledad", tipo: "Libro", fecha_reserva: "2025-02-11", fecha_entrega: "2025-23-18" },
    { titulo: "Teoría del Todo", tipo: "Artículo", fecha_reserva: "2025-02-12", fecha_entrega: "2025-02-19" },
    ];    

// Agregar reservas cuando el DOM esté listo
 document.addEventListener("DOMContentLoaded", () => {
    agregarReservas(nuevasReservas);
});