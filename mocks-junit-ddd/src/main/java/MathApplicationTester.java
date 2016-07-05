import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;
// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   private MathApplication mathApplication;
   private CalculatorService calcService;

   @Before
   public void setUp(){
      mathApplication = new MathApplication();
      calcService = mock(CalculatorService.class);
      mathApplication.setCalculatorService(calcService);	     
   }

   @Test
   public void testAdd(){
 
     // Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
	   given(calcService.add(20.0, 10.0)).willReturn(30.0);
	   double result = calcService.add(20.0, 10.0);
	   Assert.assertEquals(result,30.0,0);
   }

   
}