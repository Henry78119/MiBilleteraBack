/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.persistencia.dao;

import java.util.List;
import co.edu.udistrital.mibilletera.logica.entidades.CategoriaMovimiento;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCategoria;

/**
 *
 * @author usuario
 */
public interface CategoriaMovimientoDaoI {

    public void crearCategoria(CategoriaMovimiento categoria);

    public void editarCategoria(CategoriaMovimiento categoria);

    public CategoriaMovimiento obtenerCategoriaPorNombre(String nombreCategoria);
    
    public List<CategoriaMovimiento> obtenerCategoriaMovimientoList(TipoCategoria tipoCategoria);

}
