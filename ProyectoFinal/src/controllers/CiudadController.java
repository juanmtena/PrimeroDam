package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class CiudadController {

	private List<Ciudad> lCiudad;

	public List<Ciudad> getLista() {
		return lCiudad;
	}

	public void setLista(List<Ciudad> lCiudad) {
		this.lCiudad = lCiudad;
	}

	/*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
	public boolean add(Ciudad oCiudad) {

		boolean bExito = false;
			if (oCiudad != null && oCiudad.checkCiudad()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCiudad) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ciudad_create(?)}");
			
			}
			return bExito;
		
		/*boolean bExito = false;
		if (oCiudad != null && oCiudad.getSNombreCiudad() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCiudad) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call ciudad_create(?)}");
				statement.setString(1, json);

				statement.execute();
				statement.close();

				bExito = true;

			} catch (SQLException ex) {
				bExito = false;
			}
		}
		return bExito;*/
		
		/*boolean bExito = false;
		if (oCiudad != null && oCiudad.checkCiudad()) {
			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Ciudad VALUES (";

				if (oCiudad.getSNombreCiudad() != null) {
					sSQL += "'" + oCiudad.getSNombreCiudad() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oCiudad.getoMonumento().getSNombreMonumento() != null) {
					sSQL += "'" + oCiudad.getoMonumento().getSNombreMonumento() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";
				
				if (oCiudad.getOPais().getSNombrePais() != null) {
					sSQL += "'" + oCiudad.getOPais().getSNombrePais() + "'";
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
	public boolean remove(Ciudad oCiudad) {
		
		boolean bExito = false;
			if (oCiudad != null && oCiudad.checkCiudad()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCiudad) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ciudad_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oCiudad != null && oCiudad.getSNombreCiudad() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Ciudad WHERE nombreCiudad = ";
				if (oCiudad.getSNombreCiudad() != null) {
					sSQL += "'" + oCiudad.getSNombreCiudad() + "'";
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
	public boolean update(Ciudad oCiudad) {

		boolean bExito = false;
			if (oCiudad != null && oCiudad.checkCiudad()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCiudad) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ciudad_search_by_pk(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oCiudad != null && oCiudad.checkCiudad()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Ciudad SET ";
				sSQL += "sNombreCiudad = ";
				if (oCiudad.getSNombreCiudad() != null) {
					sSQL += "'" + oCiudad.getSNombreCiudad() + "'";
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

	// BUSCAR POR PRIMARY KEY
	public Ciudad searchByPk(Ciudad oCiudad) {

		Ciudad oCiudadResult = null;

		Gson oGson = new Gson();
		String json = "[" + oGson.toJson(oCiudad) + "]";

		try {

			CallableStatement statement = Controller.getOConnection().prepareCall("{call usuario_search_by_pk(?)}");
			statement.setString(1, json);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				oCiudadResult = new Ciudad(oCiudad.getSNombreCiudad());
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return oCiudadResult;
	}

}
