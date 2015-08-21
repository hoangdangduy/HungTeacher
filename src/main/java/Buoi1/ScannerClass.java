package Buoi1;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class ScannerClass {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner input = new Scanner(file);

			PrintStream ps = new PrintStream(new File("output.txt"));

			while (input.hasNextLine()) {
				System.out.println("OK");
				String line = input.nextLine();
				System.out.println(line);
				ps.println(line);
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
