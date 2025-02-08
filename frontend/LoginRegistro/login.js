const form = document.getElementById('formLogin'); // Se guarda en una variable el contexto de esa variable.
const submitBtn = document.getElementById('submitBtn'); // Se le da un ID diferente. 

submitBtn.addEventListener('click', async () => { // REST

    const formData = new FormData(form); // Se toma el formulario y se guarda la información de este.
    const data = {
        nombre: formData.get('nombre'),
        contrasena: formData.get('contrasena') // Este es único del Login.
    };

    try {
        const response = await fetch('http://localhost:8080/Libreria/usuario/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        const responseText = await response.text(); // Leer como texto

        try {
            const result = JSON.parse(responseText); // Intentar parsear la respuesta como JSON
            if(["Nombre de usuario no existe", "Contraseña invalida"].includes(result["token"])){
                alert(result["token"]);
            }else{
                localStorage.setItem("token", result["token"])
                location.replace("../PaginaPrincipal/paginaPrincipal.html");
            }
        } catch (error) {
            alert('Error al analizar el JSON: ' + error.message);
        }

    } catch (error) {
        alert('Error al conectar con el servidor: ' + error.message);
    }
});
