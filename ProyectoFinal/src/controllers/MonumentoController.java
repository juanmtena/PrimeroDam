package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class MonumentoController {

	private List<Monumento> lMonumento;

	public List<Monumento> getLista() {
		return lMonumento;
	}

	public void setLista(List<Monumento> lMonumento) {
		this.lMonumento = lMonumento;
	}

	/*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
	public boolean add(Monumento oMonumento) {

		boolean bExito = false;
			if (oMonumento != null && oMonumento.checkMonumento()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMonumento) + "]";
	
				bExito = Controller.executeProcedure(json, "{call monumento_create(?)}");
			
			}
			return bExito;

		/*boolean bExito = false;
		if (oMonumento != null && oMonumento.checkMonumento()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Monumento VALUES (";
				if (oMonumento.getSNombreMonumento() != null) {
					sSQL += "'" + oMonumento.getSNombreMonumento() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oMonumento.getSDireccion() != null) {
					sSQL += "'" + oMonumento.getSDireccion() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oMonumento.getORuta() != null) {
					sSQL += "'" + oMonumento.getORuta() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oMonumento.getOCiudad() != null) {
					sSQL += "'" + oMonumento.getOCiudad() + "'";
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
	public boolean remove(Monumento oMonumento) {

		boolean bExito = false;
			if (oMonumento != null && oMonumento.checkMonumento()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMonumento) + "]";
	
				bExito = Controller.executeProcedure(json, "{call monumento_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oMonumento != null && oMonumento.getSNombreMonumento() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Monumento WHERE nombreMonumento = ";
				if (oMonumento.getSNombreMonumento() != null) {
					sSQL += "'" + oMonumento.getSNombreMonumento() + "'";
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
	public boolean update(Monumento oMonumento) {

		boolean bExito = false;
			if (oMonumento != null && oMonumento.checkMonumento()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMonumento) + "]";
	
				bExito = Controller.executeProcedure(json, "{call monumento_search_by_pk(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oMonumento != null && oMonumento.checkMonumento()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Monumento SET ";

				sSQL += "nombreMonumento = ";
				if (oMonumento.getSNombreMonumento() != null) {
					sSQL += "'" + oMonumento.getSNombreMonumento() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "direccion = ";
				if (oMonumento.getSDireccion() != null) {
					sSQL += "'" + oMonumento.getSDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += " WHERE nombreMonumento = " + oMonumento.getSNombreMonumento();

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
	public Monumento searchByPk(Monumento oMonumento) {

		Monumento oMonumentoResult = null;

		Gson oGson = new Gson();
		String json = "[" + oGson.toJson(oMonumento) + "]";

		try {

			CallableStatement statement = Controller.getOConnection().prepareCall("{call monumento_search_by_pk(?)}");
			statement.setString(1, json);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				oMonumentoResult = new Monumento(oMonumento.getSNombreMonumento());
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return oMonumentoResult;
		
		/*Monumento oMonumentoResult = null;
		String sSQL = "SELECT * FROM monumento WHERE sNombreMonumento = '" + oMonumento.getSNombreMonumento() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oMonumentoResult = new Monumento(oMonumento.getSNombreMonumento());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			oMonumentoResult = null;
		}
		return oMonumentoResult;*/
	}

}
