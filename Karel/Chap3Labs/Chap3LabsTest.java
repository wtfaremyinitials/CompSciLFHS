import kareltherobot.*;

public class Chap3LabsTest extends KJRTest implements Directions
{

    public Chap3LabsTest(String name)
    {   super(name);
    }

    public void setUp()
    {   
        World.setVisible(true);
        //World.readWorld("stairworld.kwld");
        World.setDelay(10);
    }

    public void test1_moveMile()
    {   
        World.reset();
        SmartBot karel = new SmartBot(4, 1, East, 100);
        karel.moveMile();
        assertFacingEast(karel);
        assertAt(karel, 4, 9);
        assertRunning(karel);

    }

    public void test2_moveBackwards()
    {   World.reset();
        SmartBot karel = new SmartBot(6, 2, West, 100);
        karel.moveBackwards();

        assertFacingWest(karel);
        assertAt(karel,6, 3);
        assertRunning(karel);
    }

    public void test3_setupBowling()
    {   
        World.reset();
        SmartBot karel = new SmartBot(1, 1, East, 100);
        karel.setupBowling();
        
        
        assertBeepersAt(2, 5);
        assertBeepersAt(3, 4);
        assertBeepersAt(3, 6);
        assertBeepersAt(4, 3);
        assertBeepersAt(4, 5);
        assertBeepersAt(4, 7);
        assertBeepersAt(5, 2);
        assertBeepersAt(5, 4);
        assertBeepersAt(5, 6);
        assertBeepersAt(5, 8);
    }

    public void test4_plantBeepers()
    {   
        World.reset();
        SmartBot karel = new SmartBot(1, 1, East, 100);
        karel.plantBeepers();
        
        assertBeepersAt(5, 2);
        assertBeepersAt(6, 2);
        assertBeepersAt(5, 3);
        assertBeepersAt(6, 3);
        assertBeepersAt(5, 4);
        assertBeepersAt(6, 4);
        
        assertBeepersAt(2, 5);
        assertBeepersAt(3, 5);
        assertBeepersAt(4, 5);
        assertBeepersAt(5, 5);
        assertBeepersAt(6, 5);
        assertBeepersAt(7, 5);
        assertBeepersAt(8, 5);
        assertBeepersAt(9, 5);
        
        assertBeepersAt(2, 6);
        assertBeepersAt(3, 6);
        assertBeepersAt(4, 6);
        assertBeepersAt(5, 6);
        assertBeepersAt(6, 6);
        assertBeepersAt(7, 6);
        assertBeepersAt(8, 6);
        assertBeepersAt(9, 6);
        
        assertBeepersAt(5, 7);
        assertBeepersAt(6, 7);
        assertBeepersAt(5, 8);
        assertBeepersAt(6, 8);
        assertBeepersAt(5, 9);
        assertBeepersAt(6, 9);


    }

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(Chap3LabsTest.class);
    }
}