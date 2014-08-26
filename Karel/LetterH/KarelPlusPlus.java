import kareltherobot.*;

public class KarelPlusPlus extends Robot {

    private static final long serialVersionUID = 1L;

    KarelPlusPlus() {
        super(1, 1, East, 99999);
    }

    // Turn Right
    public void turnRight() {
        for(int i=0; i<3; i++) {
            this.turnLeft();
        }
    }

    // Direction Logic
    private Direction currentDirection = Direction.EAST;
    public enum Direction {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        Direction(int id) {
            this.id = id;
        }

        private int id;
        public int getID() {
            return this.id;
        }

    }

    // Rotate to face
    public void face(Direction target) {
        int turns = target.getID() - currentDirection.getID();
        if(turns > 0) {
            for(int i=0; i<turns; i++) {
                turnRight();
            }
        }
        if(turns < 0) {
            for(int i=0; i>turns; i--) {
                turnLeft();
            }
        }
        currentDirection = target;
    }

    // Reset to East
    public void reset() {
        currentDirection = Direction.EAST;
        currentX = 1;
        currentY = 1;
    }

    // Better version of move
    public boolean move(Direction target) {
        face(target);
        if(frontIsClear())
            move();
        else
            return false;
        return true;
    }

    // Move X number of times
    public int move(Direction target, int times) {
        int timesMoved = 0;
        for(int i=0; i<times; i++) {
            if(move(target))
                timesMoved++;
        }
        return timesMoved;
    }

    // Moves to a pair of coordinates
    int currentX = 1;
    int currentY = 1;
    public boolean moveTo(int targetX, int targetY) {
        boolean success = true;
        int distanceX = currentX - targetX;
        int distanceY = currentY - targetY;

        if(distanceX > 0)
            currentX = currentX - move(Direction.WEST, Math.abs(distanceX));
        else
            currentX = currentX + move(Direction.EAST, Math.abs(distanceX));

        if(distanceY > 0)
            currentY = currentY - move(Direction.SOUTH, Math.abs(distanceY));
        else
            currentY = currentY + move(Direction.NORTH, Math.abs(distanceY));

        return success;
    }
    
    // Place a beeper at the given location
    public boolean putBeeperAt(int x, int y) {
        boolean success = this.moveTo(x, y);
        this.putBeeper();
        return success;
    }

    // Move until you hit a wall
    public void go(Direction target) {
        move(target);
        while(frontIsClear())
            move(target);
    }

    // Attempt to put a beeper
    // TODO: Find what this Karel's equiv of beepersPresent()
    //public boolean tryPutBeeper() {
    //    if(!beepersPresent()) {
    //        putBeeper();
    //        return true;
    //    }
    //    return false;
    //}

    // Find room height
    public int countHeight() {
        moveTo(1, 1);
        int height = 1;
        face(Direction.NORTH);
        while(frontIsClear()) {
            move(Direction.NORTH);
            height++;
        }
        for(int i=0; i<height; i++)
            move(Direction.SOUTH);
        return height;
    }

    // Find room width
    public int countWidth() {
        moveTo(1, 1);
        int width = 1;
        face(Direction.EAST);
        while(frontIsClear()) {
            move(Direction.EAST);
            width++;
        }
        for(int i=0; i<width; i++)
            move(Direction.WEST);
        return width;
    }

}
