import kareltherobot.*;
import java.math.*;

public class BuildWorld implements RobotTask
{
    public void task()
    {
        World.reset();
        World.setTrace(true);
        World.setVisible(true);
        WorldBuilder wb = new WorldBuilder(true);
    }
}