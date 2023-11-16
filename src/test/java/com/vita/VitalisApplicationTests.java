package com.vita;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vita.services.UsuarioServices;


@SpringBootTest
class VitalisApplicationTests {
	@Autowired
	private UsuarioServices servicioUsu;
	
	@Autowired
	private BCryptPasswordEncoder encriptar;
	
	
	@Test
	void contextLoads() {
		
		System.out.println("CLAVE : "+encriptar.encode("123"));
		
		/*Usuario bean=servicioUsu.sesionDelUsuario("maria2025");
		if (bean==null)
			System.out.println("Usuario no existe");
		else {
			List<Enlace> enlaces=servicioUsu.enlacesDelUsuario(bean.getRol().getCodigo());
			enlaces.forEach(e->{
				System.out.println(e.getCodigo()+" - "+e.getDescripcion()+" - "+
									e.getRuta());
			});
		}*/
		
		
	}

}
