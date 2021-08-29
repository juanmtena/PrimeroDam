package controllers;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;

public class PagoController {

    private List<Pago> lPago;

    public List<Pago> getLista() {
        return lPago;
    }

    public void setLista(List<Pago> lPago) {
        this.lPago = lPago;
    }

    /*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
	public boolean add(Pago oPago) {

		boolean bExito = false;
			if (oPago != null && oPago.checkPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pago_create(?)}");
			
			}
			return bExito;

		/*boolean bExito = false;
		if (oPago != null && oPago.checkPago()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Pago VALUES (";
				if (oPago.getSIdPago() != null) {
					sSQL += "'" + oPago.getSIdPago() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oPago.getSFechaPago() != null) {
					sSQL += "'" + oPago.getSFechaPago() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oPago.getOMetodoPago() != null) {
					sSQL += "'" + oPago.getOMetodoPago() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ",";

				if (oPago.getOPaquete() != null) {
					sSQL += "'" + oPago.getOPaquete() + "'";
				} else {
					sSQL += "NULL";
				}

                sSQL += ",";

				if (oPago.getOCliente() != null) {
					sSQL += "'" + oPago.getOCliente() + "'";
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
	public boolean remove(Pago oPago) {

		boolean bExito = false;
			if (oPago != null && oPago.checkPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pago_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oPago != null && oPago.getSIdPago() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Pago WHERE numeroOperacion = ";
				if (oPago.getSIdPago() != null) {
					sSQL += "'" + oPago.getSIdPago() + "'";
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
	public boolean update(Pago oPago) {

		boolean bExito = false;
			if (oPago != null && oPago.checkPago()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oPago) + "]";
	
				bExito = Controller.executeProcedure(json, "{call pago_search_by_pk(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oPago != null && oPago.checkPago()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Pago SET ";

				sSQL += "numeroOperacion = ";
				if (oPago.getSIdPago() != null) {
					sSQL += "'" + oPago.getSIdPago() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "fecha = ";
				if (oPago.getSFechaPago() != null) {
					sSQL += "'" + oPago.getSFechaPago() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += " WHERE numeroOperacion = " + oPago.getSIdPago();

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
	public Pago searchByPk(Pago oPago) {

		Pago oPagoResult = null;

		Gson oGson = new Gson();
		String json = "[" + oGson.toJson(oPago) + "]";

		try {

			CallableStatement statement = Controller.getOConnection().prepareCall("{call pago_search_by_pk(?)}");
			statement.setString(1, json);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				oPagoResult = new Pago(oPago.getSIdPago());
				oPagoResult.setSFechaPago(rs.getString(2));
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return oPagoResult;
		
		/*Pago oPagoResult = null;
		String sSQL = "SELECT * FROM Pago WHERE numeroOperacion = '" + oPago.getSIdPago() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oPagoResult = new Pago(oPago.getSIdPago());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			oPagoResult = null;
		}
		return oPagoResult;*/
	}

}
