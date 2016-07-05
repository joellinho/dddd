package mock;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
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
		
		assertEquals(mathApplication.add(10.0,20.0), 30.0);
		//verificaciones de interactuar en alguna parte del codigo con el mock calculator service
		verify(calculatorservice).add(10.0, 20.0);
		verify(calculatorservice,times(1)).add(10.0, 20.0);  //se se ah realizado el mock  metodo del la clase mock alguna vez
		
	}
	

}
