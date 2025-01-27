document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        if (username === "admin" && password === "admin") {
            alert('Inicio de sesión satisfactorio');
            window.location.href = "./src/html/main.html";
        } else {
            alert("Usuario o contraseña incorrectos, ingrese nuevamente");
            loginForm.reset();
        }
    });
});