const API = "http://localhost:8080/api";

function guardarPsicologo(usuario) {
    localStorage.setItem("psicologo", JSON.stringify(usuario));
}

function obtenerPsicologo() {
    return JSON.parse(localStorage.getItem("psicologo"));
}

async function loginPsicologo(event) {
    event.preventDefault();

    const correo = document.getElementById("correo").value;
    const password = document.getElementById("password").value;

    const res = await fetch(`${API}/usuarios`);
    const usuarios = await res.json();

    const psicologo = usuarios.find(u =>
        u.correo === correo &&
        u.password === password &&
        u.rol === "PSICOLOGO"
    );

    if (psicologo) {
        guardarPsicologo(psicologo);
        window.location.href = "dashboard-psicologo.html";
    } else {
        document.getElementById("mensaje").innerText = "Datos incorrectos o usuario no es psicólogo";
    }
}

async function cargarDashboardPsicologo() {
    const usuarios = await fetch(`${API}/usuarios`).then(r => r.json());
    const emociones = await fetch(`${API}/emociones`).then(r => r.json());
    const sesiones = await fetch(`${API}/sesiones`).then(r => r.json());
    const notas = await fetch(`${API}/notas`).then(r => r.json());

    document.getElementById("totalPacientes").innerText =
        usuarios.filter(u => u.rol === "PACIENTE").length;

    document.getElementById("totalEmociones").innerText = emociones.length;
    document.getElementById("totalSesiones").innerText = sesiones.length;
    document.getElementById("totalNotas").innerText = notas.length;
}

async function cargarPacientes() {
    const usuarios = await fetch(`${API}/usuarios`).then(r => r.json());
    const pacientes = usuarios.filter(u => u.rol === "PACIENTE");

    const tabla = document.getElementById("tablaPacientes");

    pacientes.forEach(p => {
        tabla.innerHTML += `
            <tr>
                <td>${p.nombre}</td>
                <td>${p.correo}</td>
                <td>${p.rol}</td>
                <td>
                    <button class="btn" onclick="verHistorial('${p.id}')">Ver historial</button>
                </td>
            </tr>
        `;
    });
}

function verHistorial(id) {
    localStorage.setItem("pacienteSeleccionado", id);
    window.location.href = "historial-paciente.html";
}

async function cargarHistorial() {
    const pacienteId = localStorage.getItem("pacienteSeleccionado");

    const emociones = await fetch(`${API}/emociones/usuario/${pacienteId}`).then(r => r.json());
    const notas = await fetch(`${API}/notas/usuario/${pacienteId}`).then(r => r.json());

    const lista = document.getElementById("listaEmociones");
    const notasBox = document.getElementById("notasPaciente");

    emociones.forEach(e => {
        lista.innerHTML += `<p><b>${e.estado}</b> - ${e.comentario}</p>`;
    });

    notas.forEach(n => {
        notasBox.innerHTML += `<p>${n.contenido}</p>`;
    });
}

async function cargarAgendaPsicologo() {
    const sesiones = await fetch(`${API}/sesiones`).then(r => r.json());
    const contenedor = document.getElementById("listaSesiones");

    sesiones.forEach(s => {
        contenedor.innerHTML += `
            <div class="cita">
                <b>Paciente:</b> ${s.pacienteId}<br>
                <b>Fecha:</b> ${s.fechaHora}<br>
                <b>Estado:</b> ${s.estado}
            </div>
        `;
    });
}

async function cargarNotasPsicologo() {
    const notas = await fetch(`${API}/notas`).then(r => r.json());
    const tabla = document.getElementById("tablaNotas");

    notas.forEach(n => {
        tabla.innerHTML += `
            <tr>
                <td>Nota psicológica</td>
                <td>${n.fecha}</td>
                <td>${n.usuarioId}</td>
                <td><button class="btn">Ver nota</button></td>
            </tr>
        `;
    });
}