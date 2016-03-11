//Daniel Hellkamp

public class Vigenere {
	
	public static String cipher(String str, String key)
	{
		//string builder for modifying the key if it is too short
		StringBuilder sb = new StringBuilder(key);
		//string builder to return at the end of the method
		StringBuilder sb2 = new StringBuilder();
		//easier to use than ascii values, a is 0 and z is 25
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		//for the case where your key is shorter than your input
		if(key.length()<str.length())
		{
			for(int i = 0; i<str.length()-key.length(); i++)
			{
				sb.append(key.charAt(i%key.length()));
			}
			key = sb.toString();
		}
		//the actual encryption
		for(int j = 0; j<str.length(); j++)
		{
			//System.out.println("I am now adding " + str.charAt(j) + " and " + key.charAt(j));
			
			//add the alphabetic position of the spot in the key to the alphabetic position of the spot in the input
			int sum = Alphabet.indexOf(key.charAt(j)) + Alphabet.indexOf(str.charAt(j));
			//add to your string builder to be returned, mod 26 so it does not go out of bounds
			sb2.append(Alphabet.charAt(sum%26));
		}
		//return the ciphertext
		return sb2.toString();
		
	}
	
	public static void main(String[] args)
	{
		//can enter arguments here or implement a scanner to take in the arguments
		System.out.println(cipher("", ""));
	}

}
