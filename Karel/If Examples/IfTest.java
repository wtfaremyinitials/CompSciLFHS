import kareltherobot.*;

public class IfTest extends KJRTest implements Directions
{

    public IfTest(String name)
    {   super(name);
    }

    public void setUp()
    {   
        World.setVisible(true);

        World.setDelay(10);
    }

    public void test1_isBeeperOnLeft()
    {   
        World.reset();
        SmartBot karel = new SmartBot(4, 3, North, 100);
        
        // robot is in situation where no beeper on left
        assertFalse(karel.isBeeperOnLeft());
        assertRunning(karel);
        assertAt(karel, 4,3);
        assertFacingNorth(karel);

        // now there is a beeper on the left
        World.placeBeepers(4, 2, 1);
        assertTrue(karel.isBeeperOnLeft());
        assertRunning(karel);
        assertAt(karel, 4,3);
        assertFacingNorth(karel);
    }
  
     public void test2_faceEast()
    {   
        World.reset();
        SmartBot karel1 = new SmartBot(1, 1, North, 100);
        karel1.faceEast();
        assertFacingEast(karel1);
        
        SmartBot karel2 = new SmartBot(1, 2, East, 100);
        karel2.faceEast();
        assertFacingEast(karel2);
        
        SmartBot karel3 = new SmartBot(1, 3, West, 100);
        karel3.faceEast();
        assertFacingEast(karel3);
        
        SmartBot karel4 = new SmartBot(1, 4, South, 100);
        karel4.faceEast();
        assertFacingEast(karel4);
       
    }
  

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(IfTest.class);
    }
}