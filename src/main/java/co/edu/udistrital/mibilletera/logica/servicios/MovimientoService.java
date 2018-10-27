/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica.servicios;

import co.edu.udistrital.mibilletera.logica.LogicaPrincipal;
import co.edu.udistrital.mibilletera.logica.LogicaPrincipalI;
import co.edu.udistrital.mibilletera.logica.entidades.CategoriaMovimiento;
import co.edu.udistrital.mibilletera.logica.entidades.Cuenta;
import co.edu.udistrital.mibilletera.logica.entidades.Movimiento;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCategoria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
//        List<Movimiento> retValue = new ArrayList<>();
//        Cuenta cuenta = new Cuenta(id);
//        Movimiento movimiento;
//        TipoCategoria tipoCategoria = new TipoCategoria( TipoCategoria.INGRESO );
//        tipoCategoria.setNombre("AAAA");
//        CategoriaMovimiento categoria = new CategoriaMovimiento();
//        categoria.setId(2);
//        categoria.setIdTipoCategoria( tipoCategoria );
//        categoria.setNombre("test");
//        Random random = new Random();
//        for(int i = 0; i < 10; i++){
//            movimiento = new Movimiento();
//            movimiento.setId(i+1);
//            movimiento.setFechaDate( new Date() );
//            movimiento.setDescripcion("Movimiento "+i);
//            movimiento.setIdCategoriaMovimiento( categoria );
//            movimiento.setValor(random.nextDouble()*1000);
//            //movimiento.setCuenta(cuenta);
//            retValue.add(movimiento);
//        }
//        return retValue;
        return getLogicaPrincipal().obtenerMovimientosPorCuenta(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putMovimiento(Movimiento movimiento) {
        getLogicaPrincipal().crearMovimiento(movimiento);
    }

}
