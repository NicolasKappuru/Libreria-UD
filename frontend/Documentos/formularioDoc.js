
const form = document.getElementById('formDoc');
const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', async () => {

    const formData = new FormData(form);
    const data = {
        titulo: formData.get('titulo'),
        fechaPublicacion: formData.get('fechaPublicacion'),
        autores: formData.get("autores"),
        editorial: formData.get("editorial"),
        isbn: formData.get("isbn"),
        numPaginas: formData.get("numPaginas"),
        nombreCongreso: formData.get("nombreCongreso"),
        ssn: formData.get("ssn")
    };

    console.log(data)
    event.preventDefault()
    // try {
    //   const response = await fetch("http://localhost:8080/Libreria/crearDoc", {
    //     method: "POST",
    //     headers: {
    //       Authorization: `Bearer ${localStorage.getItem("token")}`,
    //       "Content-Type": "application/json",
    //     },
    //     body: JSON.stringify(data),
    //   });

    //   const responseText = await response.text(); // Leer como texto

    //   try {
    //     const result = JSON.parse(responseText); // Intentar parsear la respuesta como JSON
    //     if (
    //       ["Nombre de usuario no existe", "Contraseña invalida"].includes(
    //         result["token"]
    //       )
    //     ) {
    //       alert(result["token"]);
    //     } else {
    //       localStorage.setItem("token", result["token"]);
    //       location.replace("../PaginaPrincipal/paginaPrincipal.html");
    //     }
    //   } catch (error) {
    //     alert("Error al analizar el JSON: " + error.message);
    //   }
    // } catch (error) {
    //   alert("Error al conectar con el servidor: " + error.message);
    // }
});

function mostrarCampos(){
    let tipoDocumento = document.getElementById("tipoDocumento").value;
    document.getElementById("campoISBN").style.display = (tipoDocumento === "libro" || tipoDocumento === "ponencia") ? "block" : "none";
    document.getElementById("campoPaginas").style.display = (tipoDocumento === "libro") ? "block" : "none";
    document.getElementById("campoCongreso").style.display = (tipoDocumento === "ponencia") ? "block" : "none";
    document.getElementById("campoSSN").style.display = (tipoDocumento === "articulo") ? "block" : "none";
}