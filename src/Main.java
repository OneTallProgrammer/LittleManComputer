/**
 1xy 	LOAD 	LDA 	copy value from Mailbox with the supplied Mailbox number (xy) into the Calculator
 2xy 	STORE 	STO 	copy value from the Calculator into the Mailbox with the supplied Mailbox number (xy)
 3xy 	ADD 	ADD 	add the value in the Mailbox at the supplied Mailbox number to the Calculator; set lights
 4xy 	SUBTRACT 	SUB 	subtract the value in the Mailbox at the supplied Mailbox number from the value in the Calculator; set lights
 500 	INPUT 	IN 	copy the value currently in the Input basket to the Calculator
 600 	OUTPUT 	OUT 	copy the value from the Calculator to the Output basket
 700 	HALT 	HLT 	stop processing; sleep until the Reset button rings the bell
 800 	SKIP_IF_NEG 	SKN 	increment the Counter an extra time (skip next instruction) if the Calculator Negative indicator is on
 801 	SKIP_IF_ZERO 	SKZ 	increment the Counter an extra time (skip) if the Calculator Zero indicator is on
 802 	SKIP_IF_POS 	SKP 	increment the Counter an extra time (skip) if the Calculator Positive indicator is on
 803 	SKIP_NON_ZERO 	SKNZ 	increment the Counter an extra time (skip) if the Calculator Zero indicator is *NOT* on [not available in all LMC simulators]
 9xy 	JUMP 	JMP 	set the counter to be the value (xy) (jump to this instruction next)
 0xy 	SUBRTN_CALL 	CALL 	store 900 + <contents of counter> into Mailbox number (xy-1), then set counter to be value (xy) [not available in all LMC simulators]
 */
public class Main {

    public static void main(String[] args) {


        if (args.length == 1) {

            ComputerRoom computerRoom = new ComputerRoom(args[0]);

            computerRoom.checkForNextInstruction();

            while(computerRoom.getLittleMan().isWorking()){

                computerRoom.getLittleMan().setCurrentInstruction(computerRoom.getNextInstruction());

                computerRoom.carryOutInstruction(computerRoom.getLittleMan().parseOpCode(),
                        (computerRoom.getLittleMan().parseAddress()));

                computerRoom.incrementProgramCounter();

                computerRoom.checkForNextInstruction();

            }

        } else {

            System.out.println("Incorrect argument count");

        }

    }

}
