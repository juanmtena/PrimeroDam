package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class MetodoPagoController {

    private List<MetodoPago> lMetodoPago;

    public MetodoPagoController() {
        lMetodoPago = new ArrayList<MetodoPago>();
    }

    public List<MetodoPago> getLista() {
        return lMetodoPago;
    }

    public void setLista(List<MetodoPago> lMetodoPago) {
        this.lMetodoPago = lMetodoPago;
    }

    /*
     * ######## # CRUD # ########
     */

    // AÑADIR VALORES    
    public boolean add(MetodoPago oMetodoPago) {
        boolean bExito = false;
        System.out.println("ENTRA CABESA");
			if (oMetodoPago != null && oMetodoPago.checkMetodoPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMetodoPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call metodo_de_pago_create(?)}");
System.out.println(json);	
			}
			return bExito;

        /*boolean bExito = false;

        if (oMetodoPago != null && oMetodoPago.checkMetodoPago()) {
            try {
                Statement stmt = oConnection.createStatement();
                String sSQL = "INSERT INTO metodo_de_pago VALUES (";
                if (oMetodoPago.getSNombreMetodoPago() != null) {
                    sSQL += "'" + oMetodoPago.getSNombreMetodoPago() + "'";
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

        
       /* boolean bExito = false;
		if (oMetodoPago != null && oMetodoPago.checkMetodoPago()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oMetodoPago) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call metodo_de_pago_create(?)}");
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
    public boolean remove(MetodoPago oMetodoPago) {

        boolean bExito = false;
			if (oMetodoPago != null && oMetodoPago.checkMetodoPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMetodoPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call metodo_de_pago_delete(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
        if (oMetodoPago != null && oMetodoPago.getSNombreMetodoPago() != null) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "DELETE FROM metodo_de_pago WHERE nombreMetodoPago = ";
                if (oMetodoPago.getSNombreMetodoPago() != null) {
                    sSQL += "'" + oMetodoPago.getSNombreMetodoPago() + "'";
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

    public boolean update(MetodoPago oMetodoPago) {

		boolean bExito = false;
			if (oMetodoPago != null && oMetodoPago.checkMetodoPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oMetodoPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call metodo_de_pago_update(?)}");
	
			}
			return bExito;
    }

    // BUSCAR POR PRIMARY KEY
    public MetodoPago searchByPk(MetodoPago oMetodoPago) {

        MetodoPago oMetodoPagoResult = null;
		if (oMetodoPago != null && oMetodoPago.getSNombreMetodoPago() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oMetodoPago) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call metodo_de_pago_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oMetodoPagoResult = new MetodoPago(oMetodoPago.getSNombreMetodoPago());
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oMetodoPagoResult;

        /*MetodoPago oMetodoPagoResult = null;
        String sSQL = "SELECT * FROM metodo_de_pago WHERE nombreMetodoPago= '" + oMetodoPago.getSNombreMetodoPago() + "'";
        
        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oMetodoPagoResult = new MetodoPago(oMetodoPago.getSNombreMetodoPago());
            }
            stmt.close();
        } catch (SQLException e) {
            oMetodoPagoResult = null;
        }

        return oMetodoPagoResult;*/
    }

}
