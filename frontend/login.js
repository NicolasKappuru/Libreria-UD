const form = document.getElementById('formLogin');
const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', async () => {

    const formData = new FormData(form);
    const data = {
        nombre: formData.get('nombre'),
        contrasena: formData.get('contrasena')
    };

    console.log('Datos enviados:', data); // Verificar en la consola del navegador

    try {
        const response = await fetch('http://localhost:8080/WebPrueba/ServletLogin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        const responseText = await response.text(); // Leer como texto
        console.log('Respuesta cruda:', responseText);

        try {
            const result = JSON.parse(responseText); // Intentar parsear la respuesta como JSON
            alert(result.message); // Mostrar mensaje del servidor en una alerta
        } catch (error) {
            alert('Error al analizar el JSON: ' + error.message);
        }

    } catch (error) {
        alert('Error al conectar con el servidor: ' + error.message);
    }
});
