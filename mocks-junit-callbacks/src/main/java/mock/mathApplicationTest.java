package mock;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class mathApplicationTest {
	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	@Before
	public void setup(){
		mathApplication = new MathApplication();
		calculatorService = mock(CalculatorService.class);
		mathApplication.setCalculatorservice(calculatorService);
	}
	
	@Test
	public void testAdd(){
		
		//le damos segumiento a la respuesta que vamos a mockear del meetodo add
		when(calculatorService.add(10.0, 20.0)).thenAnswer(new Answer(){
			public Object answer(InvocationOnMock invocation) throws Throwable {
				   //get the arguments passed to mock
	            Object[] args = invocation.getArguments();
	            //get the mock 
	            Object mock = invocation.getMock();	
	            //return the result
	            return 30.0;
			}
		      });
		
		//acemos la comprovacion
		assertEquals(mathApplication.add(10.0, 20.0),30.0);
	}
	

}
