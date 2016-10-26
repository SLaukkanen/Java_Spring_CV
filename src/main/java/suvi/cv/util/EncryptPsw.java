package suvi.cv.util;

import java.util.Scanner;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptPsw {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		System.out.print("Anna salasana: ");
		String salasana = input.nextLine();
		String kryptattuna = spe.encode(salasana);
		System.out.println("Salasanasi on kryptattuna (random suola mukana): " +kryptattuna);
		

	}

}
