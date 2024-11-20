package pract.Api.Controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pract.Api.Dtos.usuarioDto;
import pract.Api.Servicios.loginImplementacion;
import pract.Api.modelos.repositorioUsuario;
import pract.Api.modelos.usuarioEntidad;

@Controller
@RequestMapping("AplicacioPrueba/usuarios")
public class ControladorApi {
	@Autowired
	private loginImplementacion login;
	@Autowired
	private repositorioUsuario repositorioUsuario;

	@GetMapping("/Login")
	public Map<String, Object> obtenerRespuesta(@RequestBody usuarioDto usuario) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			boolean usuarioAutentificado = login.autentificacionDeUsuario(usuario.getCorreoUsuario(),
					usuario.getContraseniaUsuario());

			if (usuarioAutentificado) {
				// Consultar la entidad para obtener el estado de administrador
				usuarioEntidad usuarioEntidad = repositorioUsuario.findByCorreoUsuario(usuario.getCorreoUsuario());

				if (usuarioEntidad != null) {
					// Obtener el estado de administrador
					boolean esAdmin = usuarioEntidad.getEsAdmin();
					respuesta.put("success", true);
					respuesta.put("message", "Usuario autenticado");
					respuesta.put("isAdmin", esAdmin);
					return respuesta;
				} else {
					// Usuario no encontrado después de autenticación exitosa
					respuesta.put("success", false);
					respuesta.put("message", "Usuario no encontrado en el sistema");
					return respuesta;
				}
			} else {
				// Credenciales incorrectas
				respuesta.put("success", false);
				respuesta.put("message", "Credenciales incorrectas");
				return respuesta;
			}
		} catch (Exception e) {
			// Manejo de errores generales
			respuesta.put("success", false);
			respuesta.put("message", "Error al procesar la solicitud: " + e.getMessage());
			return respuesta;
		}
	}

}
