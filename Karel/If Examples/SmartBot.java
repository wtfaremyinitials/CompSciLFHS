import kareltherobot.*;
public class SmartBot extends Robot
{

    /**
     * Constructor for smarter robot
     */
    public SmartBot(int street, int avenue, Direction facing, int beepers)
    {
        super(street, avenue, facing, beepers);
    }

    /**
     * turns robot to the right
     */
    public void turnRight()
    {  
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * turns robot to face opposite direction
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    
    
    /**
     * verifies that there is a beeper to the left
     */
    public boolean isBeeperOnLeft()
    {
        turnLeft();
        move();
        boolean beeper = nextToABeeper();
        turnAround();
        move();
        turnLeft();
        return beeper;
    }
    
    /**
     * has the robot face east
     */
    public void faceEast()
    {
        while(!facingEast())
            turnLeft();
    }
  
}
