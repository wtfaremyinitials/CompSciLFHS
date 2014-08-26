import kareltherobot.*;

public class Diagonal implements RobotTask
{
    /*
     * Move on a diagonal and put beepers at (1,1), (2,2) and (3,3)
     */
    public void task()
    {
        World.reset();
        World.setVisible(true);
        KarelPlusPlus karel = new KarelPlusPlus();
        karel.putBeeperAt(1, 1);
        karel.putBeeperAt(2, 2);
        karel.putBeeperAt(3, 3);
    }
}
