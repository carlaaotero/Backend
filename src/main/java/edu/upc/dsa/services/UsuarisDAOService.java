package edu.upc.dsa.services;


import edu.upc.dsa.db.orm.dao.UsuariDAO;
import edu.upc.dsa.db.orm.dao.UsuariDAOImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/usuarisDAO", description = "Endpoint to Usuari DAO Service")
@Path("/usuarisDAO")
public class UsuarisDAOService {

    @POST
    @ApiOperation(value = "Registrar un nou usuari a la BBDD", notes = "Afegirem un usuari nou a la BBDD")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitós", response= Usuari.class),
            @ApiResponse(code = 409, message = "El nom d'usuari ja existeix"),
            @ApiResponse(code = 401, message = "La contrasenya no coincideix"),
            @ApiResponse(code = 404, message = "Falta completar algun camp"),
            @ApiResponse(code = 500, message = "Error de validació")

    })

    @Path("/registreUsuarisDAO")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registreUsuarisDAO(Usuari usuari){
        try {
            UsuariDAO manager = UsuariDAOImpl.getInstance();
            manager.addUsuari(usuari.getNom(), usuari.getCognom(), usuari.getNomusuari(), usuari.getPassword(), usuari.getPassword2(), usuari.getCoins());
            return Response.status(201).entity(usuari).build();
        } catch (Exception e) {
            return Response.status(500).entity(usuari).build();
        }
    }


}
