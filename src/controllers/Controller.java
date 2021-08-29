package controllers;

import models.*;
import controllers.personas.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class Controller implements IController {

	private PersonasController oPersonasCtrl;
	private static Connection oConnection;
	private MonumentoController oMonumentoCtrl;
	private PaisController oPaisCtrl;
	private MetodoPagoController oMetodoPagoCtrl;
	private UbicacionController oUbicacionCtrl;
	private CiudadController oCiudadCtrl;
	private TipoPaqueteController oTipoPaqueteCtrl;
	private PaqueteController oPaqueteCtrl;
	private RutaController oRutaCtrl;
	private PagoController oPagoCtrl;
	private ParadaController oParadaCtrl;

	public Controller() {
		oPersonasCtrl = new PersonasController();
		oMonumentoCtrl = new MonumentoController();
		oPaisCtrl = new PaisController();
		oMetodoPagoCtrl = new MetodoPagoController();
		oUbicacionCtrl = new UbicacionController();
		oCiudadCtrl = new CiudadController();
		oTipoPaqueteCtrl = new TipoPaqueteController();
		oPaqueteCtrl = new PaqueteController();
		oRutaCtrl = new RutaController();
		oPagoCtrl = new PagoController();
		oParadaCtrl = new ParadaController();
	}

	public PersonasController getOPersonasCtrl() {
		return this.oPersonasCtrl;
	}

	public static Connection getOConnection() {
		return oConnection;
	}

	public MonumentoController getOMonumentoCtrl() {
		return this.oMonumentoCtrl;
	}

	public PaisController getOPaisCtrl() {
		return this.oPaisCtrl;
	}

	public MetodoPagoController getOMetodoPagoCtrl() {
		return this.oMetodoPagoCtrl;
	}

	public UbicacionController getOUbicacionCtrl() {
		return this.oUbicacionCtrl;
	}

	public CiudadController getOCiudadCtrl() {
		return this.oCiudadCtrl;
	}

	public TipoPaqueteController getOTipoPaqueteCtrl() {
		return this.oTipoPaqueteCtrl;
	}

	public PaqueteController getOPaqueteCtrl() {
		return this.oPaqueteCtrl;
	}

	public RutaController getORutaCtrl() {
		return this.oRutaCtrl;
	}

	public PagoController getOPagoCtrl() {
		return this.oPagoCtrl;
	}

	public ParadaController getOParadaCtrl() {
		return this.oParadaCtrl;
	}
	
	/*
	 * # DB METHODS
	 */
	public boolean init() throws Exception {
		boolean bExito = false;
		oConnection = connectDb();
		if (oConnection != null) {
			bExito = true;
		}
		return bExito;
	}

	public void closeDb() {
		if (oConnection != null) {
			try {
				oConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean executeProcedure(String json, String sFunction) {

		boolean bExito = false;
		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);
			if (statement.executeUpdate() > 0) {
				bExito = true;
			}
			statement.close();

		} catch (SQLException ex) {
			bExito = false;
		}

		return bExito;

	}

	public Map<String, String> getPropertiesDb() throws Exception {

		Map<String, String> mapProperties = new HashMap<String, String>();

		// Database credentials
		File file = new File(CONFIG_URL);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			linea = linea.replaceAll(" ", "");
			String sParam = linea.substring(0, linea.indexOf(":"));
			String sValue = linea.substring(linea.indexOf(":") + 1, linea.length());
			mapProperties.put(sParam, sValue);
		}
		return mapProperties;
	}

	public Connection connectDb() throws Exception {

		Map<String, String> mapProperties = getPropertiesDb();

		Connection conn = null;
		String sURL = "jdbc:mysql://" + mapProperties.get("SERVER") + ":" + mapProperties.get("PORT") + "/"
				+ mapProperties.get("DB");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(sURL, mapProperties.get("USER"), mapProperties.get("PASSWORD"));
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	/*public boolean addCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().add(oCliente, oConnection);
	}

	public boolean updateCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().update(oCliente, oConnection);
	}

	public boolean removeUsuario(Usuario oUser) {
		return oPersonasCtrl.getoUserCtrl().remove(oUser, oConnection);
	}

	public Cliente searchCliente(Cliente oCliente) {
		return oPersonasCtrl.searchCliente(oCliente, oConnection);
	}

	public Usuario searchUserByDni(Cliente oCliente) {
		return oPersonasCtrl.searchUserByDni(oCliente, oConnection);
	}

	// Metodos Clientes
	public boolean addCliente(Cliente oCliente) {
		return oPersonasCtrl.addCliente(oCliente, oConnection);
	}

	public boolean removeCliente(Cliente oCliente) {
		return oPersonasCtrl.removeCliente(oCliente, oConnection);
	}

	public boolean updateCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().update(oCliente, oConnection);
	}

	public Cliente searchCliente(Cliente oCliente) {
		return oPersonasCtrl.searchCliente(oCliente, oConnection);
	}


	// Metodos Usuarios
	public boolean addUsuario(Usuario oUsuario) {
		return oPersonasCtrl.addUsuario(oUsuario, oConnection);
	}

	public Usuario searchUsuario(Usuario oUsuario) {
		return oPersonasCtrl.searchUsuario(oUsuario, oConnection);
	}

	public boolean removeUsuario(Usuario oUsuario) {
		return oPersonasCtrl.removeUsuario(oUsuario, oConnection);
	}

	public boolean updateUsuario(Usuario oUsuario) {
		return oPersonasCtrl.getoUserCtrl().update(oUsuario, oConnection);
	}*/


	/*// Metodos Monumentos
	public boolean addMonumento(Monumento oMonumento) {
		return oMonumentoCtrl.add(oMonumento, oConnection);
	}

	public Monumento searchMonumento(Monumento oMonumento) {
		return oMonumentoCtrl.searchByPk(oMonumento, oConnection);
	}

	public boolean removeMonumento(Monumento oMonumento) {
		return oMonumentoCtrl.remove(oMonumento, oConnection);
	}

	public boolean updateMonumento(Monumento oMonumento) {
		return oMonumentoCtrl.update(oMonumento, oConnection);
	}*/

	
	/*// Metodos Pais
	public Pais searchPais(Pais oPais) {
		return oPaisCtrl.searchByPk(oPais, oConnection);
	}

	public boolean addPais(Pais oPais) {
		return oPaisCtrl.add(oPais, oConnection);
	}

	public boolean removePais(Pais oPais) {
		return oPaisCtrl.remove(oPais, oConnection);
	}*/


	/*// Metodos MetodoPago
	public boolean addMetodoPago(MetodoPago oMetodoPago) {
		return oMetodoPagoCtrl.add(oMetodoPago, oConnection);
	}

	public MetodoPago searchMetodoPago(MetodoPago oMetodoPago) {
		return oMetodoPagoCtrl.searchByPk(oMetodoPago, oConnection);
	}

	public boolean removeMetodoPago(MetodoPago oMetodoPago) {
		return oMetodoPagoCtrl.remove(oMetodoPago, oConnection);
	}*/


	/*// Metodos de Ubicacion
	public boolean addUbicacion(Ubicacion oUbicacion) {
		return oUbicacionCtrl.add(oUbicacion, oConnection);
	}

	public Ubicacion searchUbicacion(Ubicacion oUbicacion) {
		return oUbicacionCtrl.searchByPk(oUbicacion, oConnection);
	}

	public boolean removeUbicacion(Ubicacion oUbicacion) {
		return oUbicacionCtrl.remove(oUbicacion, oConnection);
	}

	public boolean updateUbicacion(Ubicacion oUbicacion) {
		return oUbicacionCtrl.update(oUbicacion, oConnection);
	}*/


	/*// Metodos Ciudad
	public boolean addCiudad(Ciudad oCiudad) {
		return oCiudadCtrl.add(oCiudad, oConnection);
	}

	public Ciudad searchCiudad(Ciudad oCiudad) {
		return oCiudadCtrl.searchByPk(oCiudad, oConnection);
	}

	public boolean removeCiudad(Ciudad oCiudad) {
		return oCiudadCtrl.remove(oCiudad, oConnection);
	}*/


	/*// Metodos Tipo de Paquete
	public boolean addTipoPaquete(TipoPaquete oTipoPaquete) {
		return oTipoPaqueteCtrl.add(oTipoPaquete, oConnection);
	}

	public TipoPaquete searchTipoPaquete(TipoPaquete oTipoPaquete) {
		return oTipoPaqueteCtrl.searchByPk(oTipoPaquete, oConnection);
	}

	public boolean removeTipoPaquete(TipoPaquete oTipoPaquete) {
		return oTipoPaqueteCtrl.remove(oTipoPaquete, oConnection);
	}

	public boolean updateTipoPaquete(TipoPaquete oTipoPaquete) {
		return oTipoPaqueteCtrl.update(oTipoPaquete, oConnection);
	}*/


	/*// Metodos Paquete
	public boolean addPaquete(Paquete oPaquete) {
		return oPaqueteCtrl.add(oPaquete, oConnection);
	}

	public Paquete searchPaquete(Paquete oPaquete) {
		return oPaqueteCtrl.searchByPk(oPaquete, oConnection);
	}

	public boolean removePaquete(Paquete oPaquete) {
		return oPaqueteCtrl.remove(oPaquete, oConnection);
	}*/


	/*// Metodos Ruta
	public boolean addRuta(Ruta oRuta) {
		return oRutaCtrl.add(oRuta, oConnection);
	}

	public Ruta searchRuta(Ruta oRuta) {
		return oRutaCtrl.searchByPk(oRuta, oConnection);
	}

	public boolean removeRuta(Ruta oRuta) {
		return oRutaCtrl.remove(oRuta, oConnection);
	}

	public boolean updateRuta(Ruta oRuta) {
		return oRutaCtrl.update(oRuta, oConnection);
	}*/

	
	/*// Metodos Pago
	public boolean addPago(Pago oPago) {
		return oPagoCtrl.add(oPago, oConnection);
	}

	public Pago searchPago(Pago oPago) {
		return oPagoCtrl.searchByPk(oPago, oConnection);
	}

	public boolean removePago(Pago oPago) {
		return oPagoCtrl.remove(oPago, oConnection);
	}

	public boolean updatePago(Pago oPago) {
		return oPagoCtrl.update(oPago, oConnection);
	}*/

	/*// Metodos Parada
	public boolean addParada(Parada oParada) {
		return oParadaCtrl.add(oParada, oConnection);
	}

	public Parada searchParada(Parada oParada) {
		return oParadaCtrl.searchByPk(oParada, oConnection);
	}

	public boolean removeParada(Parada oParada) {
		return oParadaCtrl.remove(oParada, oConnection);
	}

	public boolean updateParada(Parada oParada) {
		return oParadaCtrl.update(oParada, oConnection);
	}*/

}