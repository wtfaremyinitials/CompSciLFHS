import kareltherobot.*;
public class CountBot extends Robot
{

    /*
     * Constructor for smarter robot
     */
    int count = 0;
    public CountBot(int street, int avenue, Direction facing, int beepers)
    {
        super(street, avenue, facing, beepers);
    }

   public void turnLeft()
   {
       count++;
       super.turnLeft();
       System.out.println("" + count + "(turnLeft)");
    }
    
    public void move()
    {
        count++;
        super.move();
        System.out.println("" + count + "(move)");
    }
    
    public void putBeeper()
    {
        count++;
        super.putBeeper();
        System.out.println("" + count + "(putBeeper)");
    }
    
     public void pickBeeper()
    {
        count++;
        super.pickBeeper();
        System.out.println("" + count + "(pickBeeper)");
    }
    
    public void printCount()
    {
        System.out.println("Number of commands: " + count);
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int theCount)
    {
        count = theCount;
    }
    public void resetCount()
    {
        count = 0;
    }


}
