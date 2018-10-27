/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica.servicios;

import co.edu.udistrital.mibilletera.logica.LogicaPrincipal;
import co.edu.udistrital.mibilletera.logica.LogicaPrincipalI;
import co.edu.udistrital.mibilletera.logica.entidades.IngresosVsEgresos;
import co.edu.udistrital.mibilletera.logica.entidades.Movimiento;
import co.edu.udistrital.mibilletera.utilidades.UtilidadesFecha;
import java.util.Date;
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
@Path("reporte")
public class ReporteService {

    private LogicaPrincipalI logicaPrincipal;

    public LogicaPrincipalI getLogicaPrincipal() {
        if (logicaPrincipal == null) {
            logicaPrincipal = new LogicaPrincipal();
        }
        return logicaPrincipal;
    }

    @Path("/movimientosPorCategoria/{idCategoria}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimiento> getMovimientosPorCategoria(@PathParam("idCategoria") Integer idCategoria) {
        return getLogicaPrincipal().obtenerMovimientoPorCategoria(idCategoria);
    }

    @Path("/movimientosPorPeriodo/{fechaInicio}/{fechaFin}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimiento> getMovimientosPorPeriodo(@PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin) {
        Date fechaInicioDate = UtilidadesFecha.obtenerDatePorString(fechaInicio);
        Date fechaFinDate = UtilidadesFecha.obtenerDatePorString(fechaFin);
        return getLogicaPrincipal().obtenerMovimientoPorPeriodo(fechaInicioDate, fechaFinDate);
    }

    @Path("/movimientosPorTipo/{idTipo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimiento> getMovimientosPorTipo(@PathParam("idTipo") Integer idTipo) {
        return getLogicaPrincipal().obtenerMovimientoPorTipo(idTipo);
    }

    @Path("/ingresosVsEgresos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IngresosVsEgresos> getIngresosVsEgresos() {
        return getLogicaPrincipal().obtenerIngresosEgresos();
    }

}
