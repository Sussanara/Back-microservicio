package Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;
import com.formacionbdi.microservicios.app.usuarios.models.repository.TrabajadorRepository;

@DataJpaTest
public class TrabajadorRepositoryTests {

	@Autowired
    private TrabajadorRepository trabajadorRepository;
	
	private Trabajador trabajador;
	
	@BeforeEach
	void setup() {
		trabajador = Trabajador.builder()
					.nombre("Ivan Contreras")
					.email("ivan@gmail.com")
					.area("Marketing")
					.build();
	}
    
	@Test
     void testGuardarTrabajador() {
        Trabajador trabajador1 = Trabajador.builder()
        			.nombre("Paula Saavedra")
        			.email("paula@gmail.com")
        			.area("RR.HH")
        			.build();
        
        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador1);
        assertThat(trabajadorGuardado).isNotNull();
        assertThat(trabajadorGuardado.getId()).isGreaterThan(0);
    }
	
	@DisplayName("Test para listar a los trabajadores")
	@Test
	void testListarTrabajdores() {
		//given
		Trabajador trabajador1 = Trabajador.builder()
				.nombre("Ana Villalobos")
				.email("ana@gmail.com")
				.area("Marketing")
				.build();
		//when
		trabajadorRepository.save(trabajador1);
		trabajadorRepository.save(trabajador);
		
		//then
		assertThat(listaTrabajadores).isNotNull();
		assertThat(listaTrabajadores.size()).isEqualTo(2);
	}
}