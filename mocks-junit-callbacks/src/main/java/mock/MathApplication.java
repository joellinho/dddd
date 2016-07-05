package mock;

public class MathApplication {
private CalculatorService calculatorservice;

public CalculatorService getCalculatorservice() {
	return calculatorservice;
}

public void setCalculatorservice(CalculatorService calculatorservice) {
	this.calculatorservice = calculatorservice;
}

public double add(double input1, double input2){
  return calculatorservice.add(input1, input2);
   //return input1 + input2;
	
}
public double substract(double input1, double input2){
	return calculatorservice.substract(input1, input2);
	
}
public double multiply(double input1, double input2){
	return calculatorservice.multiply(input1, input2);
	
}
public double divide(double input1, double input2){
	return calculatorservice.divide(input1, input2);
	
}

}
