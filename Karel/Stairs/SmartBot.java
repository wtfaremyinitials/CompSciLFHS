import kareltherobot.*;
public class SmartBot extends UrRobot
{

    /*
     * Constructor for smarter robot
     */
    public SmartBot(int street, int avenue, Direction facing, int beepers)
    {
        super(street, avenue, facing, beepers);
    }

    /*
     * turns robot to the right
     */
    public void turnRight()
    {  
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*
     * turns robot to face opposite direction
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    /* 
     * climb stairs
     */
    public void climbStairs()
    {
        for(int i=0; i<3; i++)
            climbStair();
    }

    /*
     * climb a stair
     */
    public void climbStair() {
        turnLeft();
        move();
        turnRight();
        move();
        pickBeeper();
    }

}
