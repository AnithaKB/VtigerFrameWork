package Generic_Utilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * its used to return the randon number between range of 1 to 1000
	 * @return
	 * @author Anitha
	 */
	public int getRandomNumber() 
	{
		Random ranNum = new Random();
		int ranNumber = ranNum.nextInt(1000);
		return ranNumber;
		
	}

}
