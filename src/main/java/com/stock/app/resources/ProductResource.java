package com.stock.app.resources;

import com.stock.app.model.Product;
import com.stock.app.services.ProductServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
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

    @POST
    public Response createProduct(@Context UriInfo info, @Valid Product product){
        Integer id = service.createProduct(product);
        URI uri = info.getRequestUriBuilder().path("{id}").build(id);
        return Response.created(uri).build();
    }
}
