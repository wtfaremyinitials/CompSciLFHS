import kareltherobot.*;

public class StairTest extends KJRTest implements Directions
{

    public StairTest(String name)
    {   super(name);
    }

    public void setUp()
    {   
        World.setVisible(true);
        World.setTrace(false);
        World.setDelay(20);
    }

    public void test1_climbStairs()
    {   
        World.reset();
        World.readWorld("stairworld.kwld");
        SmartBot karel = new SmartBot(1, 1, East, 0);
        karel.climbStairs();
        assertFacingEast(karel);
        assertAt(karel, 4, 4);
        assertBeepersAt(2, 2, 0);
        assertBeepersAt(3, 3, 0);
        assertBeepersAt(4, 4, 0);

    }

   


    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(StairTest.class);
    }
}