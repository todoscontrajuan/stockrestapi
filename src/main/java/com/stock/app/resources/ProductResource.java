package com.stock.app.resources;

import com.stock.app.model.Product;
import com.stock.app.services.ProductServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Date;
import javax.validation.Valid;

/**
 * Created by juan_ on 12/06/2017.
 */
@Path("products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductServiceImpl service = new ProductServiceImpl();

    @GET
    public Response getAllProducts () {
        return Response.ok().entity(service.getProducts()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct (@PathParam("id") Integer id) {
        try{
            return Response.ok().entity(service.getProduct(id)).build();
        }catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response createProduct(@Context UriInfo info, @Valid Product product){
        Integer id = service.createProduct(product);
        URI uri = info.getRequestUriBuilder().path("{id}").build(id);
        return Response.created(uri).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(Product product, @PathParam("id") Integer id) {
        try {
            service.updateProduct(product, id);
            return Response.noContent().build();
        } catch (NotFoundException nfe) {
            return Response.status(Response.Status.NOT_FOUND).entity(nfe.getMessage()).build();
        } catch (IllegalArgumentException iae) {
            return Response.status(Response.Status.BAD_REQUEST).entity(iae.getMessage()).build();
        } catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Integer id){
        try{
            service.deleteProduct(id);
            return Response.noContent().build();
        }catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}/{state}")
    public Response getProductStatesByDate (
            @PathParam("id") Integer id,
            @PathParam("state") String state,
            @QueryParam("startDate") int startDate,
            @QueryParam("endDate") int endDate) {
                try{
                    Date startDate1 = new Date(startDate);
                    Date endDate1 = new Date(endDate);
                    return Response.ok().entity(service.getStatesOfProductByDate(id, state, startDate1, endDate1)).build();
                }catch (NotFoundException e){
                    return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
                }catch (Exception e){
                    return Response.serverError().entity(e.getMessage()).build();
                }
    }
}
