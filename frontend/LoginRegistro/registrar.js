const regForm = document.getElementById("formRegister");
const regSubmitBtn = document.getElementById("formSubmitBtn")

regSubmitBtn.addEventListener('click', function() {
    
    const regFormData = new FormData(regForm);
    const regData = {
        nombre: regFormData.get('nombre'),
        numeroTelefonico: regFormData.get('telefono'),
        direccionFisica: regFormData.get('direccion'),
        correoElectronico: regFormData.get('correoElectronico'),
        contrasena: regFormData.get('contrasena')
    };
    fetch('http://localhost:8080/Libreria/usuario/registrar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(regData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }
        return response.json(); // Convertir la respuesta a JSON
    })
    .then(data => {
        if(data.mensaje === "Creado"){
            alert("Usuario creado exitosamente");
            location.replace("login.html");
        }    
        else{
            alert(data.mensaje);
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
    
});
