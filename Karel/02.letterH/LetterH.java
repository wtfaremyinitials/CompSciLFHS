import kareltherobot.*;

public class LetterH implements RobotTask
{
    /*
     * Starting at 1,2 make a letter H.  See the test file for shape.
     */
    public void task()
    {
        World.reset();
        World.setVisible(true);
        KarelPlusPlus karel = new KarelPlusPlus();
       
        karel.putBeeperAt(2,1);
	    karel.putBeeperAt(2,2);
	    karel.putBeeperAt(2,3);
	    karel.putBeeperAt(2,4);
	    karel.putBeeperAt(2,5);
	    karel.putBeeperAt(3,3);
	    karel.putBeeperAt(4,3);
	    karel.putBeeperAt(5,1);
	    karel.putBeeperAt(5,2);
	    karel.putBeeperAt(5,3);
	    karel.putBeeperAt(5,4);
	    karel.putBeeperAt(5,5);
    }
}