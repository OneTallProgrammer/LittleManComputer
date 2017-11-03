/**
 * Created by joseph on 8/23/17.
 */
public class LittleMan {
    private int mailBoxNumber = 0;
    private int dataValue = 0;
    private String currentInstruction = "";

    private boolean isWorking = true;

    public int parseOpCode() {

        int opCode = -1;
        try {

            opCode = Integer.parseInt(currentInstruction.substring(0, 1));

        } catch (NumberFormatException e) {

            printErrorMessage();

        }

        return opCode;

    }

    public int parseAddress(){

        int address = -1;
        try {

            address = Integer.parseInt(currentInstruction.substring(1));

        } catch (NumberFormatException e) {}

        return address;
    }

    public void printErrorMessage(){

        isWorking = false;

        String error = "failed to process instruction " + currentInstruction;

        System.out.println(error);

    }


    public void setCurrentInstruction(String nextInstruction){

        currentInstruction = nextInstruction;

    }

    public boolean isWorking() {

        return isWorking;

    }

    public void setWorking(boolean working) {

        isWorking = working;

    }

}
