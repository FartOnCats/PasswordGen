import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class main {

	public static String cap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String lower = "abcdefghijklmnopqrstuvwxyz";
	public static String special = "!#$%&";
	
	public static void println(Object text) {
		System.out.println(text);
	}
	
	public static int randInt(int min, int max) {
	    //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	public static String typegen() {
		int typenum =  randInt(0,2);
		if(typenum == 0) {
			return "capital";
		}else if(typenum == 1) {
			return "lowercase";
		}else {
			return "special";
		}
	}
	public static char algen(String type) {
		if(type == "capital") {
			int length = cap.length();
			int rand = randInt(0,length-1);
			char chair = cap.charAt(rand);
			return chair;
		}else if(type == "lowercase") {
			int length = lower.length();
			int rand = randInt(0,length-1);
			char chair = lower.charAt(rand);
			return chair;
		}else {
			int length = special.length();
			int rand = randInt(0,length-1);
			char chair = special.charAt(rand);
			return chair;
		}
		
	}
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		//get password length
		println("Insert password length");
		int LENGTH = input.nextInt();
		//define array based on password length
		char[] password = new char[LENGTH];
		String[] typelist = new String[LENGTH];
		//for each index in the array randomly choose if that will be a CAPITAL, special character, or lowercase
		for(int i = 0;i<password.length;i++) {	
			typelist[i] = typegen();
		}
		//for each index, using its defined type, randomly choose a character for an alphabet string
		for(int i = 0; i<password.length;i++) {
			String type = typelist[i];
			password[i] = algen(type);
		}
		//combine array and display
		String passwordString = Arrays.toString(password);
		passwordString = passwordString.replaceAll(", ", "");
		passwordString = passwordString.replace("[", "");
		passwordString = passwordString.replace("]", "");
		println(passwordString);
		println("Password Copied to clipBoard");
		StringSelection stringselection = new StringSelection(passwordString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringselection, null);
	}

}
