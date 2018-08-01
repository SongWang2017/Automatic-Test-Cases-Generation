import static org.junit.Assert.*;

import org.junit.Test;

public class SampleTest {
	public static int[] input = new int[8];
	//public static int y = 4;
	//setInput();
	int x = 0;
	int y = 2;

	@Test
	public void testPower() {
		
		Sample p = new Sample();
		//x = 2;
		//setInput();
		x = input[0];
		y = input[1];
		int result = p.Power(x, y);
		assertEquals((int) Math.pow(x, y), result);
		
		x = input[2];
		y = input[3];
		result = p.Power(x, y);
		assertEquals((int) Math.pow(x, y), result);
		
		x = input[4];
		y = input[5];
		result = p.Power(x, y);
		assertEquals((int) Math.pow(x, y), result);
		
		x = input[6];
		y = input[7];
		result = p.Power(x, y);
		assertEquals((int) Math.pow(x, y), result);
	}
	
//	public static void setInput( ) {
//		this.x = AllLocuses.getLocus(0).getX();
//	}

}