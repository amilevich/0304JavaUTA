package homework.q13;

public class Main {

	public static void main(String[] args) {
		String triangle = "";
		
		//build triangle for loop
		for(int i = 0; i < 4; i++)
		{
			//Add the 0 if the string is empty and continue
			if(i == 0)
			{
				triangle += "0";
				System.out.println(triangle);
				continue;
			}
			
			//alternate between checking the last and first character
			//of the string and add a 0 if 1 and a 1 if 0.
			if(i % 2 == 0)
			{
				if(triangle.charAt(triangle.length() - 1) == '0')
				{
					triangle = triangle + '1';
				}
				else
				{
					triangle = triangle + '0';
				}
			}
			else
			{
				if(triangle.charAt(0) == '0')
				{
					triangle = '1' + triangle;
				}
				else
				{
					triangle = '0' + triangle;
				}
			}
			System.out.println(triangle);
		}
		
	}

}
