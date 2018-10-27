/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica.servicios;

import co.edu.udistrital.mibilletera.logica.LogicaPrincipal;
import co.edu.udistrital.mibilletera.logica.LogicaPrincipalI;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rfcas
 */
@Path("tipo-categoria")
public class TipoCategoriaService {

    private LogicaPrincipalI logicaPrincipal;

    public LogicaPrincipalI getLogicaPrincipal() {
        if (logicaPrincipal == null) {
            logicaPrincipal = new LogicaPrincipal();
        }
        return logicaPrincipal;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoCategoria> getTiposCategoria() {
//        List<TipoCategoria> retValue = new ArrayList<>();
//        TipoCategoria tipoCategoria;
//        for(int i = 0; i < 10; i++){
//            tipoCategoria = new TipoCategoria();
//            tipoCategoria.setId(i);
//            tipoCategoria.setNombre("xxx "+i+" xxx");            
//            retValue.add(tipoCategoria);
//        }
//        return retValue;
        return getLogicaPrincipal().obtenerTipoCategoriaList();
    }

}
