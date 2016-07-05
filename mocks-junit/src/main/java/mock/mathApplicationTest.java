package mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static junit.framework.Assert.*;

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
	}
	

}
