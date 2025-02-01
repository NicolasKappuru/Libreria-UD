const regForm = document.getElementById("formRegister");
const regSubmitBtn = document.getElementById("formSubmitBtn")

formSumbitBtn.addEventListener('click', async () => {

    const regFormData = new regFormData(regForm);
    const regData = {
        regNombre: regFormData.get('nombre'),
        regTelefono: regFormData.get('telefono'),
        regDireccion: regFormData.get('direccion'),
        regCorreo: regFormData.get('correoElectronico'),
        regContrasena: regFormData.get('contrasena')
    };

    console.log('Datos enviados para el registro.', regData) // Verificando para la consola. (DEPURACION ----->)

    try {
        const response = await fetch('http://localhost:8080/Libreria/usuarios/registrar', { // El await espera hasta que llegue una respuesta
            method: 'POST', // Se envía la petición.
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(regData),
        });

        const responseText = await response.text(); // Leer como texto
        console.log('Respuesta cruda:', responseText); // Verificar en la consola del navegador (DEPURACION ----->
                                                        // 1. Creado["El usuario fue creado exitosamente"], 
                                                        // 2. Nombre de Usuario ya Existente["Nombre de usuario ya registrado"], 
                                                        // 3. Error["Hay algun error con el servidor. (Muy raro))"].
        
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
