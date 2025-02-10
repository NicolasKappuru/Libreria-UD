const regForm = document.getElementById("formRegister");
const regSubmitBtn = document.getElementById("formSubmitBtn")

regSubmitBtn.addEventListener('click', function() {
    event.preventDefault();
    const regFormData = new FormData(regForm);
    const numeroTelefonico = regFormData.get('telefono');
    const correoElectronico = regFormData.get('correoElectronico');

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    const phoneRegex = /^\d{10}$/;

    if (!phoneRegex.test(numeroTelefonico)) {
        alert("El número de teléfono debe contener exactamente 10 dígitos.");
        return;
    }

    // Validar correo electrónico
    if (!emailRegex.test(correoElectronico)) {
        alert("El correo electrónico no es válido. Debe tener el formato nombre@correo.dominio");
        return;
    }

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
        return response.json();
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
