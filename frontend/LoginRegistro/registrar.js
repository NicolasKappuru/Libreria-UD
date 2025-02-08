const regForm = document.getElementById("formRegister");
const regSubmitBtn = document.getElementById("formSubmitBtn")
const controller = new AbortController();
const timeoutId = setTimeout(() => controller.abort(), 10000); // 10 segundos
regSubmitBtn.addEventListener('click', async () => {
    
    const regFormData = new FormData(regForm);
    const regData = {
        nombre: regFormData.get('nombre'),
        telefono: regFormData.get('telefono'),
        direccion: regFormData.get('direccion'),
        correo: regFormData.get('correoElectronico'),
        contrasena: regFormData.get('contrasena')
    };
    
    try {
        const response = await fetch('http://localhost:8080/Libreria/usuario/registrar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(regData),
            signal: controller.signal
        });

        clearTimeout(timeoutId);
        const responseText = await response.text();
        
        try {
            const result = JSON.parse(responseText); // Intentar parsear la respuesta como JSON
            if(["Creado"].includes(result["mensaje"])){
                alert(result["mensaje"]);
                location.replace("login.html");
            }else{
                alert(result["mensaje"]);
            }
        } catch (error) {
            alert('Error al analizar el JSON: ' + error.message);
        }
    } catch (error) {
        alert('Error al conectar con el servidor: ' + error.message);
    }
    
});
