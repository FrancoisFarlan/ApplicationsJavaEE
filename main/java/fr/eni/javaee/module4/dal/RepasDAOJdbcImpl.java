package fr.eni.javaee.module4.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.javaee.module4.bo.Aliment;
import fr.eni.javaee.module4.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO{
	
	private static final String INSERT_REPAS = "INSERT INTO Repas(date_repas, heure_repas) VALUES(? , ?)";
	private static final String INSERT_ALIMENTS = "INSERT INTO Aliments(id_repas, nom_aliment) VALUES(?, ?)";
	private static final String SELECT_REPAS = "SELECT id_repas, date_repas, heure_repas FROM Repas ORDER BY date_repas DESC";
	private static final String SELECT_ALIMENTS = "SELECT id_repas, nom_aliment FROM Aliments WHERE id_repas = ?";
	
	@Override
	public void insertRepas(Repas repas) throws BusinessException {
		
		if(repas==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try (Connection con = ConnectionProvider.getConnection()){
			
			List<Aliment> aliments = new ArrayList<>();
			PreparedStatement stmtrepas = con.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement stmtaliments = con.prepareStatement(INSERT_ALIMENTS);
			
			stmtrepas.setDate(1, Date.valueOf(repas.getDate()));
			stmtrepas.setTime(2, Time.valueOf(repas.getTime()));
			stmtrepas.executeUpdate();
			
			ResultSet rs = stmtrepas.getGeneratedKeys();
			
			if(rs.next()) {
				repas.setId_repas(rs.getInt(1));
				aliments = repas.getAliments();
				
				for(Aliment a : aliments) {
					stmtaliments.setInt(1, repas.getId_repas());
					a.setIdRepas(repas.getId_repas());
					stmtaliments.setString(2, a.getNomAliment());
					stmtaliments.executeUpdate();
				}
			}
			
			con.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		
	}

	@Override
	public List<Repas> selectAll() {
		List<Repas> liste = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			Statement selectrepas = con.createStatement();
			ResultSet rs = selectrepas.executeQuery(SELECT_REPAS); 
			
			PreparedStatement prepstmt = con.prepareStatement(SELECT_ALIMENTS);
			ResultSet rs2 = null; 
			
			while(rs.next()) {
				Repas repas = new Repas(rs.getInt("id_repas"), rs.getDate("date_repas").toLocalDate(), rs.getTime("heure_repas").toLocalTime());
				prepstmt.setInt(1, repas.getId_repas());
				rs2 = prepstmt.executeQuery();
				
				while(rs2.next()) {
					Aliment aliment = new Aliment(rs2.getInt("id_repas"), rs2.getString("nom_aliment"));
					repas.addAliment(aliment);
				}
				
				liste.add(repas);
			}
			con.close();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return liste;
	}

}
