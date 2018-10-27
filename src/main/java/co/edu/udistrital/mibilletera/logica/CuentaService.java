/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.mibilletera.logica;

import co.edu.udistrital.mibilletera.logica.entidades.Cuenta;
import co.edu.udistrital.mibilletera.logica.entidades.TipoCuenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cuenta> getCuentas() {
        List<Cuenta> retValue = new ArrayList<>();
        Cuenta cuenta;
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            cuenta = new Cuenta();
            cuenta.setId(i+1);
            cuenta.setFechaAperturaDate( new Date() );
            cuenta.setNombre("TEST");
            cuenta.setSaldo(random.nextDouble()*1000);
            cuenta.setTipoCuenta(TipoCuenta.values()[random.nextInt(TipoCuenta.values().length)]);
            retValue.add(cuenta);
        }
        return retValue;
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cuenta getCuenta(@PathParam("id") Integer id) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(id);
        cuenta.setFechaAperturaDate( new Date() );
        cuenta.setNombre("TEST");
        cuenta.setSaldo(0d);
        cuenta.setTipoCuenta(TipoCuenta.CORRIENTE);
        return cuenta;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCuenta(Cuenta cuenta){
        System.out.println("putCuenta("+cuenta+")");        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postCuenta(Cuenta cuenta){
        System.out.println("postCuenta("+cuenta+")"); 
    }
}
