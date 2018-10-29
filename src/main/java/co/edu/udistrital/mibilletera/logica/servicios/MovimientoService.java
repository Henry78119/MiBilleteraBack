/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica.servicios;

import co.edu.udistrital.mibilletera.logica.LogicaPrincipal;
import co.edu.udistrital.mibilletera.logica.LogicaPrincipalI;
import co.edu.udistrital.mibilletera.logica.entidades.Movimiento;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rfcas
 */
@Path("movimiento")
public class MovimientoService {

    private LogicaPrincipalI logicaPrincipal;

    public LogicaPrincipalI getLogicaPrincipal() {
        if (logicaPrincipal == null) {
            logicaPrincipal = new LogicaPrincipal();
        }
        return logicaPrincipal;
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimiento> getMovimientos(@PathParam("id") Integer id) {
        return getLogicaPrincipal().obtenerMovimientosPorCuenta(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putMovimiento(Movimiento movimiento) {
        getLogicaPrincipal().crearMovimiento(movimiento);
    }

}
