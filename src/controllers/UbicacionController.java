package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class UbicacionController {

    private List<Ubicacion> lUbicacion;

    public UbicacionController() {
        lUbicacion = new ArrayList<Ubicacion>();
    }

    public List<Ubicacion> getLista() {
        return lUbicacion;
    }

    public void setLista(List<Ubicacion> lUbicacion) {
        this.lUbicacion = lUbicacion;
    }

    /*
     * ######## # CRUD # ########
     */

    // AÑADIR VALORES
    public boolean add(Ubicacion oUbicacion) {

        boolean bExito = false;
			if (oUbicacion != null && oUbicacion.checkUbicacion()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUbicacion) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ubicacion_create(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oUbicacion != null && oUbicacion.checkUbicacion()) {

            try {
                Statement stmt = oConnection.createStatement();
                String sSQL = "INSERT INTO ubicacion VALUES (";

                if (oUbicacion.getSCoordenadas() != null) {
                    sSQL += "'" + oUbicacion.getSCoordenadas() + "'";
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
    public boolean remove(Ubicacion oUbicacion) {

        boolean bExito = false;
			if (oUbicacion != null && oUbicacion.checkUbicacion()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUbicacion) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ubicacion_delete(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oUbicacion != null && oUbicacion.getSCoordenadas() != null) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "DELETE FROM ubicacion WHERE coordenadas = ";
                if (oUbicacion.getSCoordenadas() != null) {
                    sSQL += "'" + oUbicacion.getSCoordenadas() + "'";
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
	public boolean update(Ubicacion oUbicacion) {

		boolean bExito = false;
			if (oUbicacion != null && oUbicacion.checkUbicacion()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUbicacion) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ubicacion_update(?)}");
	
			}
			return bExito;
    }

    // BUSCAR POR PRIMARY KEY
    public Ubicacion searchByPk(Ubicacion oUbicacion) {

        Ubicacion oUbicacionResult = null;
		if (oUbicacion != null && oUbicacion.getSCoordenadas() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUbicacion) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call ubicacion_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oUbicacionResult = new Ubicacion(oUbicacion.getSCoordenadas());
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oUbicacionResult;
    }

}
