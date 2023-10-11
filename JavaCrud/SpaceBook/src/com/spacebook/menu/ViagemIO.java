package com.spacebook.menu;

import java.sql.Connection;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import com.spacebook.dao.ViagemDAO;

import com.spacebook.database.DatabaseConnection;

import com.spacebook.model.Viagem;

import com.spacebook.model.Passageiro;

import com.spacebook.model.Piloto;



public class ViagemIO {

	static Connection connection = DatabaseConnection.createConnection();

	static ViagemDAO viagemDAO = new ViagemDAO(connection);

	public static int SubMenuViagem(Scanner scanner) {

		int option = Integer.MAX_VALUE;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		do {

			System.out.println("MENU VIAGEM\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"

					+ "4 - Deletar\n" + "0 - Sair");

			option = scanner.nextInt();

			switch (option) {

			case 1:

				scanner.nextLine();

				Viagem viagem = new Viagem();

				
				System.out.println("Digite a data da viagem no formato dd/MM/yyyy HH:mm:ss");

				String dataViagem = scanner.nextLine();

				viagem.setDataViagem(LocalDateTime.parse(dataViagem, formatter));

				System.out.println("Digite o Destino: ");

				viagem.setDestinoViagem(scanner.nextLine());

				System.out.println("Digite o ID do Passageiro: ");

				Passageiro passageiroViagem = new Passageiro();

				passageiroViagem.setidPassageiro(scanner.nextInt());

				System.out.println("Digite o ID do Piloto");

				Piloto pilotoViagem = new Piloto();

				pilotoViagem.setidPiloto(scanner.nextInt());

				viagemDAO.createViagem(viagem);

				break;

			case 2:

				viagemDAO.readAllViagens();

				break;

			case 3:

				Viagem viagemAtualizada = new Viagem();

				System.out.println("Digite o ID da Viagem a ser atualizada: ");

				viagemAtualizada.setIdViagem(scanner.nextInt());

				scanner.nextLine();

				System.out.println("Digite a data da viagem no formato dd/MM/yyyy HH:mm:ss");

				String dataViagemAtualizada = scanner.nextLine();


				viagemAtualizada.setDataViagem(LocalDateTime.parse(dataViagemAtualizada, formatter));

				System.out.println("Digite o Destino: ");

				viagemAtualizada.setDestinoViagem(scanner.nextLine());

				System.out.println("Digite o ID do Passageiro: ");

				Passageiro PassageiroViagemAtualizada = new Passageiro();

				PassageiroViagemAtualizada.setidPassageiro(scanner.nextInt());

				System.out.println("Digite o ID do Piloto");

				Piloto pilotoViagemAtualizada = new Piloto();

				pilotoViagemAtualizada.setidPiloto(scanner.nextInt());

				viagemDAO.updateViagem(viagemAtualizada);

				break;

			case 4:

				System.out.println("Digite o ID da Viagem a ser DELETADA");

				int idViagem = scanner.nextInt();

				viagemDAO.deleteViagem(idViagem);

				break;

			default:

				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;

	}

}