package datadriven;

public class Excls {

	public static void main(String[] args) {
		
		String input="divid";
		String output="";
		
		for(int i=input.length()-1;i>=0;i--) {
			char ch=input.charAt(i);
			output=output+ch;
			
			
		}
		
		System.out.println(output);
		
		if(output.equals(input)) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("not palindrome");
		}
	}

}
