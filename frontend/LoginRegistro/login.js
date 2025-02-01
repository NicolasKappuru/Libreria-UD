const form = document.getElementById('formLogin'); // Se guarda en una variable el contexto de esa variable.
const submitBtn = document.getElementById('submitBtn'); // Se le da un ID diferente. 

submitBtn.addEventListener('click', async () => { // REST

    const formData = new FormData(form); // Se toma el formulario y se guarda la información de este.
    const data = {
        nombre: formData.get('nombre'),
        contrasena: formData.get('contrasena') // Este es único del Login.
    };

    console.log('Datos enviados:', data); // Verificar en la consola del navegador (DEPURACIÓN ----->)


    // fetch anterior: http://localhost:8080/WebPrueba/ServletLogin
    // Yo pondría para el Formulario, usuarios/registrar
    try {
        const response = await fetch('http://localhost:8080/Libreria/usuarios/login', { // El await espera hasta que llegue una respuesta
            method: 'POST', // Se envía la petición.
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        const responseText = await response.text(); // Leer como texto
        console.log('Respuesta cruda:', responseText); // Verificar en la consola del navegador (DEPURACION ----->
                                                        // 1. Creado["El usuario fue creado exitosamente"], 
                                                        // 2. Nombre de Usuario ya Existente["Nombre de usuario ya registrado"], 
                                                        // 3. Error["Hay algun error con el servidor. (Muy extraño)"].

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
