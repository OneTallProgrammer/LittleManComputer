import java.util.Scanner;

/**
 * Created by joseph on 8/23/17.
 */
public class ComputerRoom {
    public static final int INS_SIZE = 3;

    private int mailBoxes[] = new int[100];
    private int inputBasket = 0;
    private int outputBasket = 0;
    private int programCounter = 0;
    private String instructions = null;

    private LittleMan littleMan = new LittleMan();
    private ALU calculator = new ALU();

    public ComputerRoom(String instructions) {

        this.instructions = instructions;

    }

    public void carryOutInstruction(int opCode, int address){

        switch(opCode){

            case 1:  // load
                    calculator.setCalculatorDisplay(mailBoxes[address]);
                    break;

            case 2: // store
                mailBoxes[address] = calculator.getCalculatorDisplay();
                break;

            case 3: // add
                calculator.add(mailBoxes[address]);
                calculator.setLights();
                break;

            case 4: // subtract
                calculator.add(-mailBoxes[address]);
                calculator.setLights();
                break;

            case 5: // input
                if (address == 0) {
                    inputBasket = getUserInput();
                    calculator.setCalculatorDisplay(inputBasket);
                } else {
                    littleMan.printErrorMessage();
                }
                break;

            case 6: // output
                if (address == 0) {
                    outputBasket = calculator.getCalculatorDisplay();
                    printOutput();
                } else {
                littleMan.printErrorMessage();
                }
                break;

            case 7: // halt
                if (address == 0) {
                } else {
                    littleMan.printErrorMessage();
                }
                break;

            case 8:
                switch(address){

                    case 0:
                        if(calculator.isNegative()){
                            incrementProgramCounter();
                        }
                        break;

                    case 1:
                        if(calculator.isZero()){
                            incrementProgramCounter();
                        }
                        break;

                    case 2:
                        if(!calculator.isNegative()){
                            incrementProgramCounter();
                        }
                        break;

                    case 4:
                        if(!calculator.isZero()){
                            incrementProgramCounter();
                        }
                        break;
                    default:
                        littleMan.printErrorMessage();
                        break;

                }
                break;

            case 9: // jump
                programCounter = address;
                break;

            default:
                littleMan.printErrorMessage();
                break;
        }

    }

    public void incrementProgramCounter(){

        programCounter++;

    }

    public void checkForNextInstruction(){

        // check for remaining instructions

        if(programCounter * INS_SIZE + INS_SIZE > instructions.length()){

            littleMan.setWorking(false);

        }

    }

    public String getNextInstruction(){

        return instructions.substring(programCounter * INS_SIZE, programCounter * INS_SIZE + INS_SIZE);

    }

    public LittleMan getLittleMan() {

        return littleMan;

    }

    private int getUserInput() {

        System.out.print("Input: ");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();

    }

    private void printOutput(){

        System.out.println("Output: " + outputBasket + " Negative: " + calculator.isNegative());

    }

}
