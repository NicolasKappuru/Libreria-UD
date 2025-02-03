const form = document.getElementById('formLogin');
const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', async () => {

    const formData = new FormData(form);
    const data = {
        nombre: formData.get('nombre'),
        contrasena: formData.get('contrasena')
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
