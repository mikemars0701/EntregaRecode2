package com.spacebook.menu;

import java.util.Scanner;

public class MenuIO {

	
	public static int menu(Scanner scanner) {
		System.out.println("Escolha uma opcao de 1 - 5\n" + "1 - Passageiro\n" + "2 - Piloto\n" + "3 - Viagem\n"
				+ "4 - Sair\n");
		return scanner.nextInt();
	}
	
	
}
