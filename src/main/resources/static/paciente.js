const API = "http://localhost:8080/api";

function guardarUsuarioLocal(usuario) {
    localStorage.setItem("usuario", JSON.stringify(usuario));
}

function obtenerUsuario() {
    return JSON.parse(localStorage.getItem("usuario"));
}

async function loginPaciente(event) {
    event.preventDefault();

    const correo = document.getElementById("correo").value;
    const password = document.getElementById("password").value;

    const res = await fetch(`${API}/usuarios`);
    const usuarios = await res.json();

    const usuario = usuarios.find(u => u.correo === correo && u.password === password);

    if (usuario) {
        guardarUsuarioLocal(usuario);
        window.location.href = "dashboard-paciente.html";
    } else {
        document.getElementById("mensaje").innerText = "Correo o contraseña incorrectos";
    }
}

async function registrarPaciente(event) {
    event.preventDefault();

    const usuario = {
        nombre: document.getElementById("nombre").value,
        correo: document.getElementById("correo").value,
        password: document.getElementById("password").value,
        rol: "PACIENTE"
    };

    const res = await fetch(`${API}/usuarios`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuario)
    });

    const data = await res.json();
    guardarUsuarioLocal(data);
    window.location.href = "dashboard-paciente.html";
}

async function registrarEmocion(event) {
    event.preventDefault();

    const usuario = obtenerUsuario();

    const emocion = {
        usuarioId: usuario.id,
        estado: document.getElementById("estado").value,
        comentario: document.getElementById("comentario").value
    };

    await fetch(`${API}/emociones`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(emocion)
    });

    alert("Emoción registrada correctamente");
}

async function registrarEstres(event) {
    event.preventDefault();

    const usuario = obtenerUsuario();

    const estres = {
        usuarioId: usuario.id,
        nivel: document.getElementById("nivel").value,
        causa: document.getElementById("causa").value,
        sintomas: document.getElementById("sintomas").value
    };

    await fetch(`${API}/estres`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(estres)
    });

    alert("Estrés registrado correctamente");
}

async function registrarSesion(event) {
    event.preventDefault();

    const usuario = obtenerUsuario();

    const sesion = {
        pacienteId: usuario.id,
        psicologoId: document.getElementById("psicologoId").value,
        fechaHora: document.getElementById("fechaHora").value
    };

    await fetch(`${API}/sesiones`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(sesion)
    });

    alert("Cita agendada correctamente");
}