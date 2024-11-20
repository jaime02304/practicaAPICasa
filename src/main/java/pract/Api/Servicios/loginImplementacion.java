package pract.Api.Servicios;

import org.springframework.stereotype.Service;

import pract.Api.modelos.repositorioUsuario;
import pract.Api.modelos.usuarioEntidad;

@Service
public class loginImplementacion {
	
	private  repositorioUsuario repositiorioUsuario;
	
    public boolean autentificacionDeUsuario(String correoUsuario, String contraseniaUsuario) throws Exception{
        usuarioEntidad usuario = repositiorioUsuario.findByCorreoUsuario(correoUsuario);  // Buscar usuario por correo
        return usuario != null && usuario.getContraseniaUsuario().equals(contraseniaUsuario);  // Validar contraseña
    }

}
