package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class TipoPaqueteController {
    
    private List<TipoPaquete> lTipoPaquete;

    public TipoPaqueteController() {
        lTipoPaquete = new ArrayList<TipoPaquete>();
    }

    public List<TipoPaquete> getLista() {
        return lTipoPaquete;
    }

    public void setLista(List<TipoPaquete> lTipoPaquete) {
        this.lTipoPaquete = lTipoPaquete;
    }

    /*
     * ######## # CRUD # ########
     */

    // AÑADIR VALORES
    public boolean add(TipoPaquete oTipoPaquete) {

        boolean bExito = false;
            if (oTipoPaquete != null && oTipoPaquete.checkTipoPaquete()) {
    
                Gson oGson = new Gson();
                String json = "[" + oGson.toJson(oTipoPaquete) + "]";
        
                bExito = Controller.executeProcedure(json, "{call tipo_de_paquete_create(?)}");
        
            }
            return bExito;

        /*boolean bExito = false;
        if (oTipoPaquete != null && oTipoPaquete.checkTipoPaquete()) {

            try {
                Statement stmt = oConnection.createStatement();
                String sSQL = "INSERT INTO tipo de paquete VALUES (";

                if (oTipoPaquete.getSNombrePaquete() != null) {
                    sSQL += "'" + oTipoPaquete.getSNombrePaquete() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += ",";

                if (oTipoPaquete.getsDescripcion() != null) {
                    sSQL += "'" + oTipoPaquete.getsDescripcion() + "'";
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
    public boolean remove(TipoPaquete oTipoPaquete) {

        boolean bExito = false;
			if (oTipoPaquete != null && oTipoPaquete.checkTipoPaquete()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oTipoPaquete) + "]";
	
				bExito = Controller.executeProcedure(json, "{call tipo_de_paquete_delete(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oTipoPaquete != null && oTipoPaquete.getSNombrePaquete() != null) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "DELETE FROM tipo de paquete WHERE nombrePaquete = ";
                if (oTipoPaquete.getSNombrePaquete() != null) {
                    sSQL += "'" + oTipoPaquete.getSNombrePaquete() + "'";
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

    public boolean update(TipoPaquete oTipoPaquete) {

		boolean bExito = false;
			if (oTipoPaquete != null && oTipoPaquete.checkTipoPaquete()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oTipoPaquete) + "]";
	
				bExito = Controller.executeProcedure(json, "{call tipo_de_paquete_update(?)}");
	
			}
			return bExito;
	}

    // BUSCAR POR PRIMARY KEY
    public TipoPaquete searchByPk(TipoPaquete oTipoPaquete) {
        
        TipoPaquete oTipoPaqueteResult = null;
		if (oTipoPaquete != null && oTipoPaquete.getSNombrePaquete() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoPaquete) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call tipo_de_paquete_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oTipoPaqueteResult = new TipoPaquete(oTipoPaquete.getSNombrePaquete());
                    oTipoPaqueteResult.setsDescripcion(rs.getString(2));
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oTipoPaqueteResult;
        
        /*TipoPaquete oTipoPaqueteResult = null;
        String sSQL = "SELECT * FROM tipo de paquete WHERE nombrePaquete= '" + oTipoPaquete.getsDescripcion() + "'";

        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oTipoPaqueteResult = new TipoPaquete(oTipoPaquete.getsDescripcion());
            }
            stmt.close();
        } catch (SQLException e) {
            oTipoPaqueteResult = null;
        }

        return oTipoPaqueteResult;*/
    }

}
