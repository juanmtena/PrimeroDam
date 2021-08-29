package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class ParadaController {

    private List<Parada> lParada;

	public List<Parada> getLista() {
		return lParada;
	}

	public void setLista(List<Parada> lParada) {
		this.lParada = lParada;
	}

    /*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
	public boolean add(Parada oParada) {

		boolean bExito = false;
			if (oParada != null && oParada.checkParada()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oParada) + "]";
	
				bExito = Controller.executeProcedure(json, "{call parada_create(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oParada != null && oParada.checkParada()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Parada VALUES (";
				if (oParada.getsNumeroParada() != null) {
					sSQL += "'" + oParada.getsNumeroParada() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oParada.getSNombreParada() != null) {
					sSQL += "'" + oParada.getSNombreParada() + "'";
				} else {
					sSQL += "NULL";
				}

                sSQL += ",";

				if (oParada.getSDescripcion() != null) {
					sSQL += "'" + oParada.getSDescripcion() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oParada.getoRuta() != null) {
					sSQL += "'" + oParada.getoRuta() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oParada.getOUbicacion() != null) {
					sSQL += "'" + oParada.getOUbicacion() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ")";

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;*/
	}

	// BORRAR
	public boolean remove(Parada oParada) {

		boolean bExito = false;
			if (oParada != null && oParada.checkParada()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oParada) + "]";
	
				bExito = Controller.executeProcedure(json, "{call parada_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oParada != null && oParada.getsNumeroParada() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Parada WHERE numeroParada = ";
				if (oParada.getsNumeroParada() != null) {
					sSQL += "'" + oParada.getsNumeroParada() + "'";
				} else {
					sSQL += "NULL";
				}

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;*/
	}

	// ACTUALIZAR VALORES
	public boolean update(Parada oParada) {

		boolean bExito = false;
			if (oParada != null && oParada.checkParada()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oParada) + "]";
	
				bExito = Controller.executeProcedure(json, "{call parada_update(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oParada != null && oParada.checkParada()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Parada SET ";

				sSQL += "numeroParada = ";
				if (oParada.getsNumeroParada() != null) {
					sSQL += "'" + oParada.getsNumeroParada() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "nombreParada = ";
				if (oParada.getSNombreParada() != null) {
					sSQL += "'" + oParada.getSNombreParada() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "descripcion = ";
				if (oParada.getSDescripcion() != null) {
					sSQL += "'" + oParada.getSDescripcion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += " WHERE numeroParada = " + oParada.getsNumeroParada();

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;*/
	}

	// BUSCAR POR PRIMARY KEY
	public Parada searchByPk(Parada oParada) {

		Parada oParadaResult = null;
		if (oParada != null && oParada.getsNumeroParada() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oParada) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call usuario_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oParadaResult = new Parada(oParada.getsNumeroParada());
					oParadaResult.setSNombreParada(rs.getString(2));
					oParadaResult.setSDescripcion(rs.getString(3));
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oParadaResult;
		
		/*Parada oParadaResult = null;
		String sSQL = "SELECT * FROM Parada WHERE numeroParada = '" + oParada.getsNumeroParada() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oParadaResult = new Parada(oParada.getsNumeroParada());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			oParadaResult = null;
		}
		return oParadaResult;*/
	}
    
}
