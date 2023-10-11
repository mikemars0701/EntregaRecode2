package com.spacebook.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.spacebook.dao.PassageiroDAO;
import com.spacebook.database.DatabaseConnection;
import com.spacebook.model.Passageiro;

public class PassageiroIO {

	static Connection connection = DatabaseConnection.createConnection();
	static PassageiroDAO passageiroDAO = new PassageiroDAO(connection);
	
	
	public static int SubMenuPassageiro(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU PASSAGEIRO\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar\n" + "0 - Sair");
			
			option = scanner.nextInt();
			switch(option) {
			case 1:
				Passageiro passageiro = new Passageiro();
				System.out.println("Nome completo: ");
				passageiro.setnomePassageiro(scanner.nextLine());
				// Consuma a nova linha pendente
				scanner.nextLine();
				System.out.println("CPF: ");
				passageiro.setcpfPassageiro(scanner.next().trim());
				// Consuma a nova linha pendente
				scanner.nextLine();
				System.out.println("Endereco: ");
				passageiro.setenderecoPassageiro(scanner.nextLine());
				System.out.println("Telefone: ");
				passageiro.settelefonePassageiro(scanner.next());

				passageiroDAO.createPassageiro(passageiro);
				break;
			
			
		case 2:
			passageiroDAO.readAllPassageiros();
			break;
			
		case 3:
			Passageiro passageiroAtualizado = new Passageiro();
			System.out.println("Digite o ID do passageiro a ser atualizado: ");
			passageiroAtualizado.setidPassageiro(scanner.nextInt());
			System.out.println("Nome completo: ");
			passageiroAtualizado.setnomePassageiro(scanner.nextLine());
			// Consuma a nova linha pendente
			scanner.nextLine();
			System.out.println("CPF: ");
			passageiroAtualizado.setcpfPassageiro(scanner.next().trim());
			// Consuma a nova linha pendente
			scanner.nextLine();
			System.out.println("Endereco: ");
			passageiroAtualizado.setenderecoPassageiro(scanner.nextLine());
			System.out.println("Telefone: ");
			passageiroAtualizado.settelefonePassageiro(scanner.next());

			passageiroDAO.updatePassageiro(passageiroAtualizado);

			break;
			
		case 4:
			System.out.println("Digite o ID do passageiro a ser DELETADO: ");
			int idPassageiro = scanner.nextInt();
			passageiroDAO.deletePassageiro(idPassageiro);
			break;
			
		default:
			System.out.println("Digite uma opcao valida!");
			break;

			}
			
		}while(option != 0);
		
		return option;
		
	}
	
	
	
	
	
	
}
