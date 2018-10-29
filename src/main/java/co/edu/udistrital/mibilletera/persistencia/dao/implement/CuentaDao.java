/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.persistencia.dao.implement;

import co.edu.udistrital.mibilletera.persistencia.implement.SistemaDAO;
import java.util.List;
import co.edu.udistrital.mibilletera.logica.entidades.Cuenta;
import co.edu.udistrital.mibilletera.persistencia.dao.CuentaDaoI;
import co.edu.udistrital.mibilletera.persistencia.SistemaDaoI;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class CuentaDao implements CuentaDaoI {

    private SistemaDaoI iSistemaDAO;

    public SistemaDaoI getSistemaDAO() {
        if (iSistemaDAO == null) {
            iSistemaDAO = new SistemaDAO();
        }
        return iSistemaDAO;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {        
        cuenta.setFechaAperturaDate(new Date());
        cuenta.setSaldo(0.0d);
        getSistemaDAO().crear(cuenta);
    }

    @Override
    public void editarCuenta(Cuenta cuenta) {
        getSistemaDAO().editar(cuenta);
    }

    @Override
    public List<Cuenta> obtenerListaCuenta() {
        return getSistemaDAO().buscarPorConsultaNativa("SELECT * FROM CUENTA", Cuenta.class);
    }

    @Override
    public Cuenta obtenerCuentaPorId(int id) {
        List<Cuenta> cuentaList = getSistemaDAO().buscarPorConsultaNativa(
                "SELECT * FROM CUENTA WHERE ID = ?", Cuenta.class, id);
        if (cuentaList != null && !cuentaList.isEmpty()) {
            return cuentaList.get(0);
        }
        return null;
    }

}
