import kareltherobot.*;

public class Chap5LabsTest extends KJRTest implements Directions
{

    public Chap5LabsTest(String name)
    {   super(name);
    }

    public void setUp()
    {   
        World.setVisible(true);
        World.setDelay(15);
        World.setTrace(false);
    }

    public void test1_isLeftBlocked()
    {   
        World.reset();
        SmartBot karel = new SmartBot(1, 4, North, 100);
        
        // Case 1: robot is in situation where it is not blocked on left
        assertFalse(karel.isLeftBlocked());
        assertRunning(karel);
        assertFacingNorth(karel);
        assertAt(karel, 1, 4);
        
        // Case 2: Place a wall next to Karel
        World.placeNSWall(1,3,1);
        assertTrue(karel.isLeftBlocked());
        assertRunning(karel);
        assertFacingNorth(karel);
        assertAt(karel, 1, 4);
        


    }

    public void test2_findNextDirection()
    {   World.reset();

        // put a robot on a corner with two beepers
        SmartBot karel1 = new SmartBot(6, 2, East, 100);
        World.placeBeepers(6, 2, 2);
        karel1.findNextDirection();
        assertFacingSouth(karel1);
        assertRunning(karel1);
        assertNotNextToABeeper(karel1);
         
        // put a robot on a corner with one beepers
        SmartBot karel2 = new SmartBot(7, 2, East, 100);
        World.placeBeepers(7, 2, 1);
        karel2.findNextDirection();
        assertRunning(karel2);
        assertNotNextToABeeper(karel2);
        assertFacingNorth(karel2);

    }

    public void test3_isWayBlocked()
    {   
        World.reset();
        
        // put robot in situation where it is not blocked 
        SmartBot karel = new SmartBot(2, 2, North, 100);
        World.placeNSWall(2,1,1);
        assertFalse(karel.isWayBlocked());
        assertFacingNorth(karel);
        assertRunning(karel);

        // place walls to put robot in situation where it is not blocked
        World.placeNSWall(2,2,1);
        assertFalse(karel.isWayBlocked());
        assertFacingNorth(karel);
        assertRunning(karel);
        
        // put robot in another situation where it is blocked
        World.placeEWWall(2,2,1);
        assertTrue(karel.isWayBlocked()); 
        assertFacingNorth(karel);
        assertRunning(karel);
        
        // put robot in another situation where it is not blocked
        World.placeEWWall(1,6,1);
        karel = new SmartBot(2, 6, North, 100);
        assertFalse(karel.isWayBlocked());
        assertFacingNorth(karel);
        assertRunning(karel);
        
        // put robot in another situation where it is not blocked
        World.placeEWWall(2,6,1);
        assertFalse(karel.isWayBlocked());
        assertFacingNorth(karel);
        assertRunning(karel);
        
        World.placeNSWall(2,5,1);
        assertFalse(karel.isWayBlocked());
        assertFacingNorth(karel);
        assertRunning(karel);

        // place walls to put robot in situation where it is  blocked
        World.placeNSWall(2,6,1);
        assertTrue(karel.isWayBlocked()); 
        assertFacingNorth(karel);
        assertNotRunning(karel);

    }

    public void test4_carpet()
    {   
        World.reset();
        SmartBot karel = new SmartBot(1, 1, East, 100);
        karel.carpetRooms();
    }


    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(Chap5LabsTest.class);
    }
}