package com.spacebook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.spacebook.dao.PassageiroDAO;
import com.spacebook.dao.PilotoDAO;
import com.spacebook.database.DatabaseConnection;
import com.spacebook.menu.MenuIO;
import com.spacebook.menu.PassageiroIO;
import com.spacebook.menu.PilotoIO;
import com.spacebook.menu.ViagemIO;
import com.spacebook.model.Passageiro;
import com.spacebook.model.Piloto;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {

			case 1:
				PassageiroIO.SubMenuPassageiro(scanner);
				break;
			case 2:
				PilotoIO.SubMenuPiloto(scanner);
				break;
			case 3:
				ViagemIO.SubMenuViagem(scanner);
				break;

			default:
				break;
			}

		} while (option != 4);
		

	}
}