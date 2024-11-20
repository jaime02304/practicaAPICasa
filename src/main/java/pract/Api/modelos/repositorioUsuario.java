package pract.Api.modelos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioUsuario extends JpaRepository<usuarioEntidad,Long> {

	
	usuarioEntidad findByCorreoUsuario(String correoUsuario);
}
