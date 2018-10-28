/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.persistencia.dao.implement;

import co.edu.udistrital.mibilletera.persistencia.implement.SistemaDAO;
import java.util.List;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCategoria;
import co.edu.udistrital.mibilletera.persistencia.SistemaDaoI;
import co.edu.udistrital.mibilletera.persistencia.dao.TipoCategoriaDaoI;

/**
 *
 * @author usuario
 */
public class TipoCategoriaDao implements TipoCategoriaDaoI {

    private SistemaDaoI iSistemaDAO;

    public SistemaDaoI getSistemaDAO() {
        if (iSistemaDAO == null) {
            iSistemaDAO = new SistemaDAO();
        }
        return iSistemaDAO;
    }

    @Override
    public List<TipoCategoria> obtenerTipoCategoriaList() {
        return getSistemaDAO().buscarPorConsultaNativa(
                "SELECT * FROM tipoCategoria", TipoCategoria.class);
    }

}
