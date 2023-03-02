package ControllerTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.formacionbdi.microservicios.app.usuarios.controllers.TrabajadorController;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;
import com.formacionbdi.microservicios.app.usuarios.services.TrabajadorService;

@SpringBootTest
public class ControllerTest {
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;
    
    private static final long ID = 1L;
    
    private static final String NOMBRE = "Paula Saavedra";
    private static final String EMAIL = "paula@gmail.com";
    private static final String AREA = "RR.HH";
    
    private static final String NOMBRE2 = "Ana Villalobos";
    private static final String EMAIL2 = "any@gmail.com";
    private static final String AREA2 = "Marketing";
    
    private static final String NOMBRE3 = "Yerko Vasquez";
    private static final String EMAIL3 = "yerko@gmail.com";
    private static final String AREA3 = "Sostenibilidad";
    
    private static final List<Trabajador> LISTA_TRABAJADORES = new ArrayList<>();
   
    @Mock
    private TrabajadorService trabajadorService;
   
    @InjectMocks
    private TrabajadorController trabajadorController;
	private Object trabajadorDetails;
   
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        trabajador1.setId(ID);
        trabajador1.setNombre(NOMBRE);
        trabajador1.setEmail(EMAIL);
        trabajador1.setArea(AREA);
        
        trabajador2.setId(ID);
        trabajador2.setNombre(NOMBRE2);
        trabajador2.setEmail(EMAIL2);
        trabajador2.setArea(AREA2);
        
        trabajador3.setId(ID);
        trabajador3.setNombre(NOMBRE3);
        trabajador3.setEmail(EMAIL3);
        trabajador3.setArea(AREA3);
        
        when(trabajadorService.obtenerTrabajadorPorId(ID)).thenReturn(trabajador1);
        when(trabajadorService.eliminarTrabajador(ID)).thenReturn(1);
        when(trabajadorService.agregarTrabajador(trabajador1)).thenReturn(trabajador1);
        when(trabajadorService.editarTrabajador(trabajador2)).thenReturn(trabajador2);
    }
    
    @Test
    public void testListadoTrabajadores() {
        final List<Trabajador> trabajadores = trabajadorController.listado();
        assertThat(trabajadores).isEqualTo(LISTA_TRABAJADORES);
    }
   
    @Test
    public void testTrabajadorPorId() {
        final Trabajador trabajador = trabajadorController.obtenerPorId(ID);
        assertThat(trabajador).isNotNull();
        assertThat(trabajador).isInstanceOf(Trabajador.class);
        assertThat(trabajador.getNombre()).isEqualTo(NOMBRE);
        assertThat(trabajador.getEmail()).isEqualTo(EMAIL);
        assertThat(trabajador.getArea()).isEqualTo(AREA);
    }
   
    @Test
    public void testAgregarNuevoTrabajador() {
        Trabajador trabajadorN = trabajador1;
        final Trabajador trabajador = trabajadorController.agregar(trabajadorN);
        assertThat(trabajador).isNotNull();
        assertThat(trabajador).isInstanceOf(Trabajador.class);
        assertThat(trabajador.getNombre()).isEqualTo(NOMBRE);
        assertThat(trabajador.getEmail()).isEqualTo(EMAIL);
        assertThat(trabajador.getArea()).isEqualTo(AREA);
    }
    
    @Test
	public void updateTrabajadorTest() {
		Long trabajadorId = 1L;
		Optional<Trabajador> oTrabajador = trabajadorService.findById(trabajadorId);
		assertTrue(oTrabajador.isPresent());

		Trabajador personDetails = new Trabajador();
		personDetails.setNombre("Paula Saavedra");
		personDetails.setEmail("paula@gmail.com");
		personDetails.setArea("RR.HH");

		ResponseEntity<?> responseEntity = update(trabajadorDetails, trabajadorId);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		Trabajador updatedTrabajador = (Trabajador) responseEntity.getBody();

		assertEquals(trabajadorId, updatedTrabajador.getId());
		assertEquals("Paula Saavedra", updatedTrabajador.getNombre());
		assertEquals("paula@gmail.com", updatedTrabajador.getEmail());
		assertEquals("RR.HH", updatedTrabajador.getArea());
    }

	private ResponseEntity<?> update(Object trabajadorDetails2, Long trabajadorId) {
		// TODO Auto-generated method stub
		return null;
	}

    