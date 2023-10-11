package com.spacebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.spacebook.model.Piloto;
import com.spacebook.model.Passageiro;
import com.spacebook.model.Viagem;

public class ViagemDAO {

	private static String sql;

	private final Connection connection;

	public ViagemDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createViagem(Viagem viagem) {
		sql = "INSERT INTO Viagem (dataViagem, destinoViagem, idPassageiro, idPiloto) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Datas
			Timestamp sqlViagem = Timestamp.valueOf(viagem.getDataViagem());
			stmt.setTimestamp(1, sqlViagem);
			stmt.setString(2, viagem.getDestinoViagem());
			stmt.setInt(3, viagem.getPassageiro().getidPassageiro());
			stmt.setInt(4, viagem.getPiloto().getidPiloto());
			stmt.executeUpdate();
			System.out.println("[LOG] Viagem criada com sucesso! " + "Destino: " + viagem.getDestinoViagem() + " e "
					+ "Data: " + viagem.getDataViagem());
		} catch (SQLException e) {
			System.out.println("Não foi possível criar a viagem. Mensagem: " + e.getMessage());
		}
	}

	// READ
	public void readAllViagens() {

		sql = "SELECT * FROM viagem as v " + "INNER JOIN passageiro as p " + "ON v.idPassageiro = p.idPassageiro"
				+ "INNER JOIN Piloto as t " + "ON v.idPiloto = t.idPiloto";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Viagem viagem = new Viagem();

				viagem.setIdViagem(r.getInt("idViagem"));
				viagem.setDataViagem(r.getTimestamp("dataViagem").toLocalDateTime());
				viagem.setDestinoViagem(r.getString("destinoViagem"));

				// Passageiro
				Passageiro passageiro = new Passageiro();

				passageiro.setidPassageiro(r.getInt("idPassageiro"));
				passageiro.setnomePassageiro(r.getString("nomePassageiro"));
				passageiro.setcpfPassageiro(r.getString("cpfPassageiro"));
				passageiro.setenderecoPassageiro(r.getString("enderecoPassageiro"));
				passageiro.settelefonePassageiro(r.getString("telefonePassageiro"));
				passageiro.setemailPassageiro(r.getString("emailPassageiro"));
				passageiro.setsenhaPassageiro(r.getString("senhaPassageiro"));

				// Piloto
				Piloto piloto = new Piloto();

				piloto.setidPiloto(r.getInt("idpiloto"));
				piloto.setnomePiloto(r.getString("nomepiloto"));
				piloto.setespecialidadePiloto(r.getString("especialidade"));
				piloto.setcertificacaoPiloto(r.getString("certificacao"));

				System.out.println("ID viagem: " + viagem.getIdViagem() + "\nData da viagem: " + viagem.getDataViagem()
						+ "\nDestino da viagem: " + viagem.getDestinoViagem() + "\nNome do Passageiro: "
						+ passageiro.getnomePassageiro() + "\nNome do piloto: " + piloto.getnomePiloto());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// UPDATE
	public void updateViagem(Viagem viagem) {
		sql = "UPDATE Viagem SET dataViagem = ?, destinoViagem = ?, idPassageiro = ?, idPiloto = ? WHERE idViagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Datas
			Timestamp sqlViagem = Timestamp.valueOf(viagem.getDataViagem());
			stmt.setTimestamp(1, sqlViagem);

			stmt.setString(2, viagem.getDestinoViagem());
			stmt.setInt(3, viagem.getPassageiro().getidPassageiro());
			stmt.setInt(4, viagem.getPiloto().getidPiloto());
			stmt.setInt(5, viagem.getIdViagem());

			stmt.executeUpdate();
			System.out.println("[LOG] Viagem criada com sucesso! " + "Destino: " + viagem.getDestinoViagem() + " e "
					+ "Data: " + viagem.getDataViagem());
		} catch (SQLException e) {
			System.out.println("Não foi possível criar a viagem. Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteViagem(int id) {
		sql = "DELETE FROM viagem WHERE idViagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("[LOG] Viagem DELETADA com sucesso!");
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível deletar a viagem. Mensagem: " + e.getMessage());

		}
	}

}
