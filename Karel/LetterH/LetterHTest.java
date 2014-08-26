import kareltherobot.*;


public class LetterHTest extends KJRTest implements Directions
{

	public LetterHTest(String name)
	{	super(name);
	}


	public void setUp()
	{	LetterH lh = new LetterH();
	    lh.task();
	}


	
	public void testH()
	{	
	    assertBeepersAt(1,2);
	    assertBeepersAt(2,2);
	    assertBeepersAt(3,2);
	    assertBeepersAt(4,2);
	    assertBeepersAt(5,2);
	    assertBeepersAt(3,3);
	    assertBeepersAt(3,4);
	    assertBeepersAt(1,5);
	    assertBeepersAt(2,5);
	    assertBeepersAt(3,5);
	    assertBeepersAt(4,5);
	    assertBeepersAt(5,5);

	}



	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(LetterHTest.class);
	}
}