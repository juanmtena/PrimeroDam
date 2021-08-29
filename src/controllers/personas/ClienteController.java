package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;
import controllers.*;

public class ClienteController {

	private List<Cliente> lClientes;

	public ClienteController() {
		lClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getLista() {
		return lClientes;
	}

	public void setLista(List<Cliente> lClientes) {
		this.lClientes = lClientes;
	}

	/*
	 * ######## # CRUD # ########
	 */

	// INSERTAR VALORES
	public boolean add(Cliente oCliente) {
		
		boolean bExito = false;
			if (oCliente != null && oCliente.checkCliente()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCliente) + "]";
	
				bExito = Controller.executeProcedure(json, "{call cliente_create(?)}");
	
			}
			return bExito;
		
		
		/*boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Cliente VALUES (";
				if (oCliente.getSDni() != null) {
					sSQL += "'" + oCliente.getSDni() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSNombre() != null) {
					sSQL += "'" + oCliente.getSNombre() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSApellidos() != null) {
					sSQL += "'" + oCliente.getSApellidos() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSFechaNacimiento() != null) {
					sSQL += "'" + oCliente.getSFechaNacimiento() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSDireccion() != null) {
					sSQL += "'" + oCliente.getSDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSDireccion() != null) {
					sSQL += "'" + oCliente.getSDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSPais() != null) {
					sSQL += "'" + oCliente.getSPais() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSProvincia() != null) {
					sSQL += "'" + oCliente.getSProvincia() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getSTelefono() != null) {
					sSQL += "'" + oCliente.getSTelefono() + "'";
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
	public boolean remove(Cliente oCliente) {

		boolean bExito = false;
			if (oCliente != null && oCliente.checkCliente()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCliente) + "]";
	
				bExito = Controller.executeProcedure(json, "{call cliente_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oCliente != null && oCliente.getsDni() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Cliente WHERE dni = ";
				if (oCliente.getsDni() != null) {
					sSQL += "'" + oCliente.getsDni() + "'";
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
	public boolean update(Cliente oCliente) {
		
		boolean bExito = false;
			if (oCliente != null && oCliente.checkCliente()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oCliente) + "]";
	
				bExito = Controller.executeProcedure(json, "{call cliente_update(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Cliente SET ";

				sSQL += "sNombre = ";
				if (oCliente.getsNombre() != null) {
					sSQL += "'" + oCliente.getsNombre() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sApellidos = ";
				if (oCliente.getsApellidos() != null) {
					sSQL += "'" + oCliente.getsApellidos() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sDireccion = ";
				if (oCliente.getsDireccion() != null) {
					sSQL += "'" + oCliente.getsDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sFechaNacimiento = ";
				if (oCliente.getsFechaNacimiento() != null) {
					sSQL += "'" + oCliente.getsFechaNacimiento() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sDireccion = ";
				if (oCliente.getsTelefono() != null) {
					sSQL += "'" + oCliente.getsTelefono() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sPais = ";
				if (oCliente.getsDireccion() != null) {
					sSQL += "'" + oCliente.getsDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sProvincia = ";
				if (oCliente.getsProvincia() != null) {
					sSQL += "'" + oCliente.getsProvincia() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += " WHERE dni = " + oCliente.getsDni();

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
	public Cliente searchByPk(Cliente oCliente) {
		Cliente oClienteResult = null;
		if (oCliente != null && oCliente.getsDni() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call cliente_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oClienteResult = new Cliente(oCliente.getsDni());
					oClienteResult.setsNombre(rs.getString(2));
					oClienteResult.setsApellidos(rs.getString(3));
					oClienteResult.setsFechaNacimiento(rs.getString(4));
					oClienteResult.setsTelefono(rs.getString(5));
					oClienteResult.setsDireccion(rs.getString(6));
					oClienteResult.setsProvincia(rs.getString(7));
					oClienteResult.setoUsuario(new Usuario(rs.getString(8)));
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oClienteResult;
	}

}

