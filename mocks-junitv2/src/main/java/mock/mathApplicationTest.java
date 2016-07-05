package mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.runners.MockitoJUnitRunner;
import static junit.framework.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class mathApplicationTest {
	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	//@InjectMocks
	//MathApplication mathApplication = new MathApplication();
	
	//@Mock
	//CalculatorService calculatorservice;
	
	@Before
	public void setup(){
		mathApplication = new MathApplication();
		calculatorService = mock(CalculatorService.class);
		mathApplication.setCalculatorservice(calculatorService);
	}
	
	@Test
	public void testAdd(){
		when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);
		
		assertEquals(mathApplication.add(10.0,20.0), 30.0);
	}
	

}
