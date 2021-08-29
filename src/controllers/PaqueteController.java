package controllers;

import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class PaqueteController {
    
    private PaqueteController oPaqueteCtrl;

	public PaqueteController() {
		
	}

	public PaqueteController getoPaqueteCtrl() {
		return oPaqueteCtrl;
	}

    /*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
    public boolean add(Paquete oPaquete) {

		boolean bExito = false;
			if (oPaquete != null && oPaquete.checkPaquete()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPaquete) + "]";
	
				bExito = Controller.executeProcedure(json, "{call paquete_create(?)}");
			
			}
			return bExito;
		
		/*boolean bExito = false;
		if (oPaquete != null && oPaquete.getSIdPaquete() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPaquete) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call paquete_create(?)}");
				statement.setString(1, json);

				statement.execute();
				statement.close();

				bExito = true;

			} catch (SQLException ex) {
				bExito = false;
			}
		}
		return bExito;*/
    }

    // BORRAR
	public boolean remove(Paquete oPaquete) {

		boolean bExito = false;
			if (oPaquete != null && oPaquete.checkPaquete()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPaquete) + "]";
	
				bExito = Controller.executeProcedure(json, "{call paquete_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oPaquete != null && oPaquete.getSIdPaquete() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM paquete WHERE idPaquete = ";
				if (oPaquete.getSIdPaquete() != null) {
					sSQL += "'" + oPaquete.getSIdPaquete() + "'";
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
	public boolean update(Paquete oPaquete) {

		boolean bExito = false;
			if (oPaquete != null && oPaquete.checkPaquete()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPaquete) + "]";
	
				bExito = Controller.executeProcedure(json, "{call paquete_search_by_pk(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oPaquete != null && oPaquete.checkPaquete()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE paquete SET ";
				sSQL += "sIdPaquete = ";
				if (oPaquete.getSIdPaquete() != null) {
					sSQL += "'" + oPaquete.getSIdPaquete() + "'";
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
	public Paquete searchByPk(Paquete oPaquete) {

		Paquete oPaqueteResult = null;

		Gson oGson = new Gson();
		String json = "[" + oGson.toJson(oPaquete) + "]";

		try {

			CallableStatement statement = Controller.getOConnection().prepareCall("{call paquete_search_by_pk(?)}");
			statement.setString(1, json);
			
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				oPaqueteResult = new Paquete(oPaquete.getSIdPaquete());
				oPaqueteResult.setSIdPaquete(rs.getString(2));
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return oPaqueteResult;
	}

}
