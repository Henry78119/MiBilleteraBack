/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica.servicios;

import co.edu.udistrital.mibilletera.logica.LogicaPrincipal;
import co.edu.udistrital.mibilletera.logica.LogicaPrincipalI;
import co.edu.udistrital.mibilletera.logica.entidades.Cuenta;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rfcas
 */
@Path("cuenta")
public class CuentaService {

    private LogicaPrincipalI logicaPrincipal;

    public LogicaPrincipalI getLogicaPrincipal() {
        if (logicaPrincipal == null) {
            logicaPrincipal = new LogicaPrincipal();
        }
        return logicaPrincipal;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cuenta> getCuentas() {        
        return getLogicaPrincipal().obtenerListaCuenta();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cuenta getCuenta(@PathParam("id") Integer id) {
        return getLogicaPrincipal().obtenerCuentaPorId(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCuenta(Cuenta cuenta) {
        System.out.println("postCuenta("+cuenta+")");
        getLogicaPrincipal().editarCuenta(cuenta);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postCuenta(Cuenta cuenta) {
        System.out.println("postCuenta("+cuenta+")");
        getLogicaPrincipal().crearCuenta(cuenta);
    }
}
