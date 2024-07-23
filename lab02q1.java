import java.util.Scanner;

public class StringManipulation {
	public static void main(String[] args){
		Scanner sc=new Scanner(system.in);

		System.out.print ("Enter your first name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter you MID name: ");
		String MIDName = sc.nextLine();

		System.out.print("Enter your Last name: ");
		String LastName = sc.nextLine();

		String fullName = firstName+" "+MIDName+" "+LastName;
		
		System.out.print("Full name is:"+fullName);
		sc.close();
	}
}
