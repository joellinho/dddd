package mock;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class mathApplicationTest {
	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	// @InjectMocks
	// MathApplication mathApplication = new MathApplication();

	// @Mock
	// CalculatorService calculatorservice;

	@Before
	public void setup() {
		mathApplication = new MathApplication();
		calculatorService = mock(CalculatorService.class);
		mathApplication.setCalculatorservice(calculatorService);
	}

	@Test
	public void testAdd() {
		//falceamos el metodo add y substrac no importa el orden aqui
		when(calculatorService.add(10.0, 10.0)).thenReturn(20.0);
		when(calculatorService.substract(20.0, 10.0)).thenReturn(10.0);
		//veirficamos que los metodos sean correctos primero restar y luego sumar en ese orden
		assertEquals(mathApplication.substract(20.0, 10.0), 10.0);
		assertEquals(mathApplication.add(10.0, 10.0), 20.0);
		//objecto verificador de orden
		InOrder inOrder = inOrder(calculatorService);

		//verificamos si se llamaron en este orden los mock add y substrac
		inOrder.verify(calculatorService).substract(20.0, 10.0);
		inOrder.verify(calculatorService).add(10.0, 10.0);
		//de no ser asi dan una excepcion en este caso si es correcto
	}

}
