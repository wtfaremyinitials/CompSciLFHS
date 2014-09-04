
import kareltherobot.RobotTask;

public class TuringKarel implements RobotTask {
    /**
     *     Variables 
     */
    boolean  halted = false;
    int      state  = 0;
    String[] program = null;
    
    /**
     *     Constructor
     */
    public TuringKarel() {
        program = new String[999];
    }
    
    /**
     *     Run the task
     */
    public void task() {
        while (!halted) {
            doStep();
        }
    }
    
    public void doStep() {
        String instruction = program[state];
    }
}
