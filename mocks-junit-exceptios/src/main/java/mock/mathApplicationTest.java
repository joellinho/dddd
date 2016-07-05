package mock;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class mathApplicationTest {
	
	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calculatorservice;
	
	@Test
	public void testAdd(){
	//manejar excepciones en pruebas unitarias
		when(calculatorservice.add(20.0, 10.0)).thenReturn(30.0);
		doThrow(new RuntimeException("add operation not implemented")).when(calculatorservice).add(20.0, 10.0);//cuando el metodo recive estos parametros lanza una excepcion aun asi si se hubiera implementado con when
		assertEquals(mathApplication.add(20.0,10.0), 30.0);
		//
		
	
	}
	

}
