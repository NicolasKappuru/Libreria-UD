const form = document.getElementById('formLogin'); // Se guarda en una variable el contexto de esa variable.
const submitBtn = document.getElementById('submitBtn'); // Se le da un ID diferente. 

submitBtn.addEventListener('click', function() { // REST

    const formData = new FormData(form); // Se toma el formulario y se guarda la información de este.
    const data = {
        nombre: formData.get('nombre'),
        contrasena: formData.get('contrasena') // Este es único del Login.
    };

    fetch('http://localhost:8080/Libreria/usuario/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then(response =>{
        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }
        return response.json();
    }).then(data => {
        if(["Nombre de usuario no existe", "Contraseña invalida"].includes(data.token)){
            alert(data.token);
        }else{
            localStorage.setItem("token", data.token)
            location.replace("../PaginaPrincipal/paginaPrincipal.html");
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });   
    
});
