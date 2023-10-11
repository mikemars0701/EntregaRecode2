package com.spacebook.menu;

import java.sql.Connection;
import java.util.Scanner;
import com.spacebook.dao.PilotoDAO;
import com.spacebook.database.DatabaseConnection;
import com.spacebook.model.Piloto;

public class PilotoIO {

	static Connection connection = DatabaseConnection.createConnection();
	static PilotoDAO pilotoDAO = new PilotoDAO(connection);

	public static int SubMenuPiloto(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU PILOTO\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar\n" + "0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				Piloto piloto = new Piloto();
				System.out.println("Nome completo: ");
				piloto.setnomePiloto(scanner.nextLine());
				// Consuma a nova linha pendente
				scanner.nextLine();

				System.out.println("Especialidade: ");
				piloto.setespecialidadePiloto(scanner.nextLine());
				scanner.nextLine();
				System.out.println("certificacao: ");
				piloto.setcertificacaoPiloto(scanner.next());

				pilotoDAO.createPiloto(piloto);
				break;

			case 2:
				pilotoDAO.readAllPilotos();
				break;

			case 3:
				Piloto pilotoAtualizado = new Piloto();
				System.out.println("Digite o ID do piloto a ser atualizado: ");
				pilotoAtualizado.setidPiloto(scanner.nextInt());
				System.out.println("Nome completo: ");
				pilotoAtualizado.setnomePiloto(scanner.nextLine());
				// Consuma a nova linha pendente
				scanner.nextLine();

				System.out.println("Especialidade: ");
				pilotoAtualizado.setespecialidadePiloto(scanner.nextLine());
				System.out.println("Certificacao: ");
				pilotoAtualizado.setcertificacaoPiloto(scanner.next());

				pilotoDAO.updatePiloto(pilotoAtualizado);

				break;

			case 4:
				System.out.println("Digite o ID do piloto a ser DELETADO: ");
				int idPiloto = scanner.nextInt();
				pilotoDAO.deletePiloto(idPiloto);
				break;

			default:
				System.out.println("Digite uma opcao valida!");
				break;

			}

		} while (option != 0);
		
		return option;

	}

}
