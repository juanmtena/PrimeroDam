package controllers;

import models.*; 
import java.sql.*;
import java.util.ArrayList;          // ##### FINALIZADO DEL TODO #####  
import java.util.List;
import com.google.gson.*;

public class PaisController  {

    private List<Pais> lPais;

    public PaisController() {
        lPais = new ArrayList<Pais>();
    }

    public List<Pais> getLista() {
        return lPais;
    }

    public void setLista(List<Pais> lPais) {
        this.lPais = lPais;
    }

    /*
     * ######## # CRUD # ########
     */

    // INSERTAR VALORES
    public boolean add(Pais oPais) {

        boolean bExito = false;
			if (oPais != null && oPais.checkPais()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPais) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pais_create(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oPais != null && oPais.checkPais()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPais) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call pais_create(?)}");
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
        if (oPais != null && oPais.checkPais()) {
            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "INSERT INTO Pais VALUES (";

                if (oPais.getSNombrePais() != null) {
                    sSQL += "'" + oPais.getSNombrePais() + "'";
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
    public boolean remove(Pais oPais) {

        boolean bExito = false;
			if (oPais != null && oPais.checkPais()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPais) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pais_delete(?)}");
	
			}
			return bExito;

        /*boolean bExito = false;
		if (oPais != null && oPais.checkPais()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPais) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call pais_delete(?)}");
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
        System.out.println(oPais);
        if (oPais != null && oPais.getSNombrePais() != null) {

            try {
                Statement stmt = oConnection.createStatement();
                String sSQL = "DELETE FROM Pais WHERE nombrePais = ";
                if (oPais.getSNombrePais() != null) {
                    sSQL += "'" + oPais.getSNombrePais() + "'";
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
    public boolean update(Pais oPais) {

        boolean bExito = false;
			if (oPais != null && oPais.checkPais()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPais) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pais_update(?)}");
	
			}
			return bExito;

        /*Pais oPaisResult = null;
        String sSQL = "SELECT * FROM Pais WHERE nombrePais = '" + oPais.getSNombrePais() + "'";
    
        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oPaisResult = new Pais(oPais.getSNombrePais());
            }
            stmt.close();
        } catch (SQLException e) {
            oPaisResult = null;
        }

        return oPaisResult;*/
    }

    // BUSCAR POR PRIMARY KEY
    public Pais searchByPk(Pais oPais) {
        Pais oPaisResult = null;
		if (oPais != null && oPais.getSNombrePais() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPais) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call pais_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oPaisResult = new Pais(oPais.getSNombrePais());
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oPaisResult;
	}

}
