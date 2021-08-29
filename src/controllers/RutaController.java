package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class RutaController {
    
    private List<Ruta> lRuta;

    public RutaController() {
        lRuta = new ArrayList<Ruta>();
    }

    public List<Ruta> getLista() {
        return lRuta;
    }

    public void setLista(List<Ruta> lRuta) {
        this.lRuta = lRuta;
    }

    /*
     * ######## # CRUD # ########
     */

    // AÑADIR VALORES
    public boolean add(Ruta oRuta) {

        boolean bExito = false;
			if (oRuta != null && oRuta.checkRuta()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oRuta) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ruta_create(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oRuta != null && oRuta.checkRuta()) {

            try {
                Statement stmt = oConnection.createStatement();
                String sSQL = "INSERT INTO Ruta VALUES (";

                if (oRuta.getSIdRuta() != null) {
                    sSQL += "'" + oRuta.getSIdRuta() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += ",";

                if (oRuta.getSNombreRuta() != null) {
                    sSQL += "'" + oRuta.getSNombreRuta() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += ",";

                if (oRuta.getSDuracion() != null) {
                    sSQL += "'" + oRuta.getSDuracion() + "'";
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
    public boolean remove(Ruta oRuta) {

        boolean bExito = false;
			if (oRuta != null && oRuta.checkRuta()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oRuta) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ruta_delete(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oRuta != null && oRuta.getSIdRuta() != null) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "DELETE FROM Ruta WHERE idRuta = ";
                if (oRuta.getSIdRuta() != null) {
                    sSQL += "'" + oRuta.getSIdRuta() + "'";
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
    public boolean update(Ruta oRuta) {

        boolean bExito = false;
			if (oRuta != null && oRuta.checkRuta()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oRuta) + "]";
	
				bExito = Controller.executeProcedure(json, "{call ruta_update(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oRuta != null && oRuta.checkRuta()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Ruta SET duracion = ";
				if (oRuta.getSDuracion() != null) {
					sSQL += "'" + oRuta.getSDuracion() + "'";
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
    public Ruta searchByPk(Ruta oRuta) {

        Ruta oRutaResult = null;
		if (oRuta != null && oRuta.getSIdRuta() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oRuta) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call ruta_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oRutaResult = new Ruta(oRuta.getSIdRuta());
					oRutaResult.setSNombreRuta(rs.getString(2));
					oRutaResult.setSDuracion(rs.getString(3));
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oRutaResult;

        /*Ruta oRutaResult = null;
        String sSQL = "SELECT * FROM Ruta WHERE idRuta = '" + oRuta.getSIdRuta() + "'";

        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oRutaResult = new Ruta(oRuta.getSIdRuta());
            }
            stmt.close();
        } catch (SQLException e) {
            oRutaResult = null;
        }

        return oRutaResult;*/
    }

    

}
