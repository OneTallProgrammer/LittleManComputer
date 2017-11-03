
public class ALU {
    private final int OVERFLOW_THRESHOLD = 999;

    private int calculatorDisplay = 0;
    private boolean isNegative = false;
    private boolean isZero = true;

    public void add(int addend){

        if(isNegative()){
            calculatorDisplay -= addend;
        }
        else {
            calculatorDisplay += addend;
        }

        checkForOverflow();

    }

    public int getCalculatorDisplay() {

        return calculatorDisplay;

    }

    public void setCalculatorDisplay(int calculatorDisplay) {

        this.calculatorDisplay = calculatorDisplay;

        checkForOverflow();

    }

    private void checkForOverflow() {

        if(calculatorDisplay > OVERFLOW_THRESHOLD){

            calculatorDisplay -= OVERFLOW_THRESHOLD;

            isNegative = !isNegative;

        }

    }

    public void setLights() {

        if(calculatorDisplay == 0){

            isZero = true;

        }
        else{

            isZero = false;

        }

        if(calculatorDisplay < 0){

            calculatorDisplay = -calculatorDisplay;

            isNegative = !isNegative();

        }
    }

    public boolean isNegative() {

        return isNegative;

    }

    public boolean isZero() {

        return isZero;

    }
}
