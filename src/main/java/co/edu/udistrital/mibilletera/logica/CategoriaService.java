/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica;

import co.edu.udistrital.mibilletera.logica.entidades.CategoriaMovimiento;
import co.edu.udistrital.mibilletera.logica.entidades.Movimiento;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rfcas
 */
@Path("categoria")
public class CategoriaService {
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaMovimiento> getCategoriasMovimiento(@PathParam("id") Integer idTipoCategoria) {
        List<CategoriaMovimiento> retValue = new ArrayList<>();
        CategoriaMovimiento categoriaMovimiento;
        TipoCategoria tipoCategoria = new TipoCategoria(idTipoCategoria);
        for(int i = 0; i < 10; i++){
            categoriaMovimiento = new CategoriaMovimiento();
            categoriaMovimiento.setId(i+1);
            categoriaMovimiento.setNombre("yyy "+i+" yyy");
            categoriaMovimiento.setIdTipoCategoria(tipoCategoria);
            retValue.add(categoriaMovimiento);
        }
        return retValue;
    }
    
}
