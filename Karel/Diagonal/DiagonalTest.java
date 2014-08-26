import kareltherobot.*;


public class DiagonalTest extends KJRTest implements Directions
{

	public DiagonalTest(String name)
	{	super(name);
	}


	public void setUp()
	{	Diagonal bot = new Diagonal();
	    bot.task();
	}


	
	public void testDiagonal()
	{	
	    assertBeepersAt(1,1);
	    assertBeepersAt(2,2);
	    assertBeepersAt(3,3);
	    
	}



	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(DiagonalTest.class);
	}
}