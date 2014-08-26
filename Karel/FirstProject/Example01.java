import kareltherobot.*;

public class Example01 implements RobotTask
{
    public void task()
    {
        World.setVisible(true);
 
        UrRobot karel = new UrRobot(1, 2, East, 1);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;  
        karel.move();
        karel.putBeeper();
        karel.move();  
        karel.move();       
        karel.turnLeft(); 
        karel.putBeeper();
        karel.move();  
    }
}