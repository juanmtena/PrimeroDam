package controllers.personas;

import models.Cliente;
import models.Usuario;

public class PersonasController {
    
    private UsuarioController oUserCtrl;
    private ClienteController oClientCtrl;

    public PersonasController() {
        oUserCtrl = new UsuarioController();
        oClientCtrl = new ClienteController();
    }

    public UsuarioController getoUserCtrl() {
        return oUserCtrl;
    }

    public ClienteController getoClientCtrl() {
        return oClientCtrl;
    }

    /*
     * # CONTROLLER METHODS
     */
    
    public Cliente searchCliente(Cliente oCliente) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente);
        Usuario oUsuario = oUserCtrl.searchByPk(oClienteRes.getoUsuario());
        oClienteRes.setoUsuario(oUsuario);
        return oClienteRes;
    }

    public Usuario searchUserByDni(Cliente oCliente) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente);
        Usuario oUsuario = null;
        if (oClienteRes != null) {
            oUsuario = oUserCtrl.searchByPk(oClienteRes.getoUsuario());
        }
        return oUsuario;
    }


    /*
    // METODOS CLIENTES
    public boolean addCliente(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oUserCtrl.add(oCliente.getoUsuario(), oConnection)) {
            if (oClientCtrl.add(oCliente)) {
                bExito = true;
            } else {
                oUserCtrl.remove(oCliente.getoUsuario(), oConnection);
            }
        }
        return bExito;
    }

    public boolean removeCliente(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oClientCtrl.remove(oCliente, oConnection)) {
            bExito = true;
        }
        return bExito;
    }

    // METODOS USUARIOS
    public boolean addUsuario(Usuario oUsuario, Connection oConnection) {
        boolean bExito = false;
        
        if (oUserCtrl.add(oUsuario, oConnection)) {
            bExito = true;
        }

        return bExito;
    }

    public Usuario searchUsuario(Usuario oUsuario, Connection oConnection) {
        return oUserCtrl.searchByPk(oUsuario, oConnection);
    }

    public boolean removeUsuario(Usuario oUsuario, Connection oConnection) {
        boolean bExito = false;
        if (oUserCtrl.remove(oUsuario, oConnection)) {
            bExito = true;
        }
        return bExito;
    }*/

}
