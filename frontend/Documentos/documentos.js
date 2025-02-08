const libros = [
    { titulo: "Libro 1", fecha: "2024/11/30", autores: "Autor A", editorial: "Editorial X", estado: "Nuevo", propietario: "Juan", isbn: "123456", paginas: 200 },
    { titulo: "Libro 2", fecha: "2023/02/21", autores: "Autor B", editorial: "Editorial Y", estado: "Usado", propietario: "María", isbn: "789012", paginas: 150 }
];
const articulos = [
    { titulo: "Artículo 1", fecha: "2022/05/13", autores: "Autor C", editorial: "Revista Z", estado: "Publicado", propietario: "Luis", ssn: "321654" }
];
const ponencias = [
    { titulo: "Ponencia 1", fecha: "2021/08/09", autores: "Autor D", editorial: "Conferencia W", estado: "Aceptado", propietario: "Ana", congreso: "Congreso 1", ssn: "987654" }
];
let indices = { libros: 0, articulos: 0, ponencias: 0 };
function displayDocument(tipo) {
    const container = document.getElementById(tipo + "Fields");
    container.innerHTML = "";
    const data = eval(tipo)[indices[tipo]] || null;
    if (data) {
        for (let key in data) {
            container.innerHTML += `<div><strong>${key.toUpperCase()}:</strong> ${data[key]}</div>`;
        }
    } else {
        container.innerHTML = "<div>Null</div>";
    }
}
function nextDocument(tipo) {
    if (indices[tipo] < eval(tipo).length - 1) {
        indices[tipo]++;
    } else {
        indices[tipo] = 0;
    }
    displayDocument(tipo);
}
displayDocument("libros");
displayDocument("articulos");
displayDocument("ponencias");