import kareltherobot.*;
public class SmartBot extends CountBot
{

    /*
     * Constructor for smarter robot
     */
    public SmartBot(int street, int avenue, Direction facing, int beepers)
    {
        super(street, avenue, facing, beepers);
    }

    /*
     * Turns right
     */
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    /*
     * verifies that there is a wall to left
     */
    public boolean isLeftBlocked()
    {
        turnLeft();
        boolean blocked = !frontIsClear();
        turnRight();
        return blocked;
    }

    /*
     * plants beepers around a cross
     */
    public void findNextDirection()
    {
        pickBeeper();
        if(nextToABeeper()) {
            faceSouth();
            pickBeeper();
        } else {
            faceNorth();
        }
    }
    
    public void faceNorth() {
        while(!facingNorth())
            turnLeft();
    }
    
    public void faceSouth() {
        while(!facingSouth())
            turnLeft();
    }
    
    public void faceEast() {
        while(!facingEast())
            turnLeft();
    }
    
    public void faceWest() {
        while(!facingWest())
            turnLeft();
    }
    
    public Direction getCurrentDirection() {
        if(facingNorth())
            return North;
        if(facingSouth())
            return South;
        if(facingEast())
            return East;
        if(facingWest())
            return West;
        return null;
    }
    
    public void faceDirection(Direction target) {
        if(target == North)
            faceNorth();
        if(target == South)
            faceSouth();
        if(target == East)
            faceEast();
        if(target == West)
            faceWest();
    }
    
     /*
     * verifies that there is a wall to left
     */
    public boolean isWayBlocked()
    {
        
        Direction start = getCurrentDirection();
        boolean blocked = true;
        
        turnRight();
        if(frontIsClear())
           blocked = false;
        turnLeft();
        if(frontIsClear())
           blocked = false;
        turnLeft();
        if(frontIsClear())
           blocked = false;
        
       turnLeft();   
       if(!frontIsClear() && blocked) {
           faceDirection(start);
           turnOff();
           return blocked;
       }
        
        faceDirection(start);
        return blocked;
    }
    
    /*
     * Carpet rooms
     */
    public void carpetRooms() {
        for(int i=0; i<9; i++)
             carpetRoom();
    }
    
    public void carpetRoom() {
        turnLeft();
        move();
        if(isWayBlocked())
            putBeeper();
        turnAround();
        move();
        turnLeft();
        move();
    }
}
