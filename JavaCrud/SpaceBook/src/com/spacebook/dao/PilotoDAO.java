package com.spacebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spacebook.model.Piloto;

public class PilotoDAO {

	private static String sql;

	private final Connection connection;

	public PilotoDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createPiloto(Piloto piloto) {

		sql = "ISERT INTO piloto (nomePiloto, especialidadePiloto, certificacaoPiloto) VALUES (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, piloto.getnomePiloto());
			stmt.setString(2, piloto.getespecialidadePiloto());
			stmt.setString(3, piloto.getcertificacaoPiloto());
			

			stmt.executeUpdate();
			System.out.println("[LOG] Piloto criado com sucesso! " + "Nome: " + piloto.getnomePiloto() + " e "
					+ "Especialidade: " + piloto.getespecialidadePiloto());
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel criar o piloto. Mensagem: " + e.getMessage());
		}
	}

	// READ
	public void readAllPilotos() {
		sql = "SELECT * FROM piloto";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Piloto piloto = new Piloto();
				piloto.setnomePiloto(r.getString("nomePiloto"));
				piloto.setespecialidadePiloto(r.getString("especialidadePiloto"));
				piloto.setcertificacaoPiloto(r.getString("certificacaoPiloto"));
				
				

				System.out.printf("Nome: %s\n Especialidade: %s\n  Certificacao: %s", piloto.getnomePiloto(),
						piloto.getespecialidadePiloto(), piloto.getcertificacaoPiloto());

			}

			if (!r.next()) {
				System.out.println("[LOG] Não há dados");
			}

		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível acessar as informações. Mensagem: " + e.getMessage());
		}

	}

	// UPDATE
	public void updatePiloto(Piloto piloto) {
		sql = "UPDATE piloto SET nomePiloto = ?, especialidadePiloto = ?, certificacaoPiloto = ? WHERE idPiloto = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, piloto.getnomePiloto());
			stmt.setString(2, piloto.getespecialidadePiloto());
			stmt.setString(3, piloto.getcertificacaoPiloto());
			stmt.setInt(5, piloto.getidPiloto());

			stmt.executeUpdate();
			System.out.println("[LOG] Piloto atualizado com sucesso! " + "Nome: " + piloto.getnomePiloto() + " e "
					+ "Especialidade: " + piloto.getespecialidadePiloto());

		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível atualizar o piloto. Mensagem: " + e.getMessage());
		}

	}

	// DELETE
	public void deletePiloto(int id) {
		sql = "DELETE FROM piloto WHERE idPiloto = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("[LOG] Piloto DELETADO com sucesso!");
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível deletar o piloto. Mensagem: " + e.getMessage());

		}
	}

}
