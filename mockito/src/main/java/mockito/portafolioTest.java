package mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
public class portafolioTest {
	portafolio market ;
	ServiceStock servicestock;
	public static void main(String[] args) {
		portafolioTest tester = new portafolioTest();
		tester.setup();
		System.out.println(tester.testmarket()?"pass":"fail");
		
		
	}
	public void setup(){
		market = new portafolio();
		servicestock = mock(ServiceStock.class);
		market.setServicestock(servicestock);
		
	}
	public boolean testmarket(){
		List<Stock> lista = new ArrayList<Stock>();
		Stock net = new Stock("1","windowsserver",1);
		Stock ibm = new Stock("2","jboss",1);
		lista.add(net);
		lista.add(ibm);
		market.setLista(lista);
		when(servicestock.getPrecio(net)).thenReturn(50.00);
		when(servicestock.getPrecio(ibm)).thenReturn(100.00);
		
		double valor=market.valorcartera();
		return valor ==150.00;
	
	}
	
	
}
