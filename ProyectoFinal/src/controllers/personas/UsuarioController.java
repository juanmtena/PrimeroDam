package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;             // ##### FINALIZADO DEL TODO #####
import com.google.gson.*;
import controllers.*;

public class UsuarioController {
    
    private List<Usuario> lUsuarios;

	public UsuarioController() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getLista() {
		return lUsuarios;
	}

	public void setLista(List<Usuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

    /*
	 * ######## # CRUD # ########
	 */

    //AÑADIR USUARIO
	public boolean add(Usuario oUsuario) {

		boolean bExito = false;
			if (oUsuario != null && oUsuario.checkUsuario()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUsuario) + "]";
	
				bExito = Controller.executeProcedure(json, "{call usuario_create(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO usuario VALUES (";
				if (oUsuario.getsEmail() != null) {
					sSQL += "'" + oUsuario.getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
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

	
    //ELEMINAR USUARIO
	public boolean remove(Usuario oUsuario) {

		boolean bExito = false;
			if (oUsuario != null && oUsuario.getsEmail() != null) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUsuario) + "]";
	
				bExito = Controller.executeProcedure(json, "{call usuario_delete(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oUsuario != null && oUsuario.getsEmail() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM usuario WHERE email = ";
				if (oUsuario.getsEmail() != null) {
					sSQL += "'" + oUsuario.getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "password = ";
				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
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

    //ACTUALIZAR DATOS
	public boolean update(Usuario oUsuario) {

		boolean bExito = false;
			if (oUsuario != null && oUsuario.checkUsuario()) {

				Gson oGson = new Gson();
				String json = "[" + oGson.toJson(oUsuario) + "]";
	
				bExito = Controller.executeProcedure(json, "{call usuario_update(?)}");
	
			}
			return bExito;

		/*boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE usuario SET password = ";
				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += " WHERE email = ";
				if (oUsuario.getsEmail() != null) {
					sSQL += "'" + oUsuario.getsEmail() + "'";
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

    //BUSCAR USUARIO POR PRIMARY KEY - LOGIN
	public Usuario searchByPk(Usuario oUsuario) {

		Usuario oUsuarioResult = null;
		if (oUsuario != null && oUsuario.getsEmail() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUsuario) + "]";

			try {

				CallableStatement statement = Controller.getOConnection().prepareCall("{call usuario_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oUsuarioResult = new Usuario(oUsuario.getsEmail());
					oUsuarioResult.setsPassword(rs.getString(2)); //No me pillaba el set, si no entra, es posible que sea de aquí
				}

				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oUsuarioResult;

		/*Usuario oUsuarioResult = null;
		String sSQL = "SELECT * FROM usuario WHERE email = '" + oUsuario.getsEmail() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oUsuarioResult = new Usuario(oUsuario.getsEmail());
				oUsuarioResult.setsPassword(rs.getString(2));
			}
			stmt.close();
		} catch (SQLException e) {
			oUsuarioResult = null;
		}

		return oUsuarioResult;*/
	}

	public List<Usuario> readAll() {
		List<Usuario> lUsuarios = new ArrayList<Usuario>();

		try {

			CallableStatement statement = Controller.getOConnection().prepareCall("{call usuario_search_all()}");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario oUsuario = new Usuario(rs.getString(1));
				oUsuario.setsPassword(rs.getString(2));
				lUsuarios.add(oUsuario);
			}

			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lUsuarios;
	}
	

}
