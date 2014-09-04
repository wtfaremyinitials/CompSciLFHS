import kareltherobot.*;
public class SmartBot extends KarelPlusPlus
{

    /*
     * Constructor for smarter robot
     */
    public SmartBot(int street, int avenue, kareltherobot.World.Direction facing, int beepers)
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
     * moves 1 mile = 8 blocks
     */
    public void moveMile()
    {
        for(int i=0; i<8; i++) {
            move();
        }
    }

    /*
     * goes one space backwards but does not change facing
     */
    public void moveBackwards()
    {
        turnAround();
        move();
        turnAround();
    }

    /*
     * sets up bowling pins
     */
    public void setupBowling()
    {
        moveTo(2, 5);
        placePins(4);
    }
    
    public void plantBeepers() {
        World.readWorld("gardenworld.kwld");
        moveTo(2, 6);
        face(KarelPlusPlus.Direction.EAST);
        line();
    }
    
    public void line() {
        while(frontIsClear()) {
            putBeeper();
            move();
        }
    }
    
    public void placePins(int pins) {
        face(KarelPlusPlus.Direction.EAST);
        for(int i=0; i<pins; i++) {
            putBeeper();
            move();
            move();
        }
        face(KarelPlusPlus.Direction.WEST);
        for(int i=0; i<pins*2; i++) {
            move();
        }
        face(KarelPlusPlus.Direction.SOUTH);
        move();
        face(KarelPlusPlus.Direction.EAST);
        move();
        if(pins != 1)
            placePins(pins-1);
    }
     
}
