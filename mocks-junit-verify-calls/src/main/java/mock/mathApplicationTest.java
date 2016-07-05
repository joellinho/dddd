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
		when(calculatorservice.add(10.0, 20.0)).thenReturn(30.0);
		when(calculatorservice.add(20.0, 20.0)).thenReturn(40.0);
		when(calculatorservice.substract(20.0, 10.0)).thenReturn(10.0);
		//when(calculatorservice.multiply(20.0, 20.0)).thenReturn(4000.0);
		assertEquals(mathApplication.add(10.0,20.0), 30.0);
		
		
		assertEquals(mathApplication.add(20.0,20.0), 40.0);
		assertEquals(mathApplication.add(20.0,20.0), 40.0);
		assertEquals(mathApplication.substract(20.0, 10.0), 10.0);
		//verificaciones de interactuar en alguna parte del codigo con el mock calculator service
		verify(calculatorservice).add(10.0, 20.0);
		verify(calculatorservice,times(1)).add(10.0, 20.0);  //se se ah realizado el mock  metodo del la clase mock alguna vez
		verify(calculatorservice,times(2)).add(20.00,20.00); //se ha llamado 2 veses al mock service.add a traves del when mathapplication
		verify(calculatorservice,never()).multiply(10.0,20.0);// nunca se llamo a este metodo
		verify(calculatorservice,atLeastOnce()).substract(20.0, 10.0);// se llamo almenos una vez
		verify(calculatorservice,atLeast(2)).add(20.0, 20.0);//llamada almenos 2 veces			
		verify(calculatorservice,atMost(2)).add(20.0,20.0);//llamada hasta 2 veces maximo
	
	}
	

}
