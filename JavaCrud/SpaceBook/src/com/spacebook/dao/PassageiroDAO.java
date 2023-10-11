package com.spacebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spacebook.model.Passageiro;

public class PassageiroDAO {

	private static String sql;

	private final Connection connection;

	public PassageiroDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createPassageiro(Passageiro passageiro) {

		sql = "ISERT INTO passageiro (emailPassageiro, senhaPassageiro, nomePassageiro, cpfPassageiro, enderecoPassageiro, telefonePassageiro) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, passageiro.getemailPassageiro());
			stmt.setString(2, passageiro.getsenhaPassageiro());
			stmt.setString(3, passageiro.getnomePassageiro());
			stmt.setString(4, passageiro.getcpfPassageiro());
			stmt.setString(5, passageiro.getenderecoPassageiro());
			stmt.setString(6, passageiro.gettelefonePassageiro());

			stmt.executeUpdate();
			System.out.println("[LOG] Passageiro criado com sucesso! " + "Nome: " + passageiro.getnomePassageiro() + " e " +
					"CPF: " + passageiro.getcpfPassageiro());
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel criar o passageiro. Mensagem: " + e.getMessage());
		}
	}

	// READ
	public void readAllPassageiros() {
		sql = "SELECT * FROM passageiro";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Passageiro passageiro = new Passageiro();
				passageiro.setemailPassageiro(r.getString("emailPassageiro"));
				passageiro.setsenhaPassageiro(r.getString("senhaPassageiro"));
				passageiro.setnomePassageiro(r.getString("nomePassageiro"));
				passageiro.setcpfPassageiro(r.getString("cpfPassageiro"));
				passageiro.setenderecoPassageiro(r.getString("enderecoPassageiro"));
				passageiro.settelefonePassageiro(r.getString("telefonePassageiro"));
				
				System.out.printf("Email: %s\n Senha: %s\n Nome: %s\n CPF: %s\n Endereco: %s\n Telefone: %s", passageiro.getnomePassageiro(),
						passageiro.getcpfPassageiro(), passageiro.getenderecoPassageiro(), passageiro.gettelefonePassageiro());
				
			}

			if(!r.next()) {
				System.out.println("[LOG] Não há dados");
			}
			
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível acessar as informações. Mensagem: " + e.getMessage());
		}

	}

	//UPDATE
	public void updatePassageiro (Passageiro passageiro) {
		sql="UPDATE passageiro SET nomePassageiro = ?, cpfPassageiro = ?, enderecoPassageiro = ?, telefonePassageiro = ? WHERE idPassageiro = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, passageiro.getemailPassageiro());
			stmt.setString(2, passageiro.getsenhaPassageiro());
			stmt.setString(3, passageiro.getnomePassageiro());
			stmt.setString(4, passageiro.getcpfPassageiro());
			stmt.setString(5, passageiro.getenderecoPassageiro());
			stmt.setString(6, passageiro.gettelefonePassageiro());
			stmt.setInt(7, passageiro.getidPassageiro());
			
			stmt.executeUpdate();
			System.out.println("[LOG] Passageiro atualizado com sucesso! " + "Email: " + passageiro.getemailPassageiro() + "Senha: " + passageiro.getsenhaPassageiro() + "Nome: " + passageiro.getnomePassageiro() +
					"CPF: " + passageiro.getcpfPassageiro() + "Endereço: " + passageiro.getenderecoPassageiro() + "Telefone: " + passageiro.gettelefonePassageiro());
			
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível atualizar o passageiro. Mensagem: " + e.getMessage());
		}
		
	}

	//DELETE
	public void deletePassageiro (int id) {
		sql = "DELETE FROM passageiro WHERE idPassageiro = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("[LOG] Passageiro DELETADO com sucesso!");
		}catch (SQLException e) {
			System.out.println("[LOG] Não foi possível deletar o passageiro. Mensagem: " + e.getMessage());
			
		}
	}


}

