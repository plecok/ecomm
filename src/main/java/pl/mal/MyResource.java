
package pl.mal;

import pl.mal.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class MyResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hi")
    public String getIt() {
        return "Hi there!\n";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product")
    public Product getProduct(){
        return new Product("bbb");
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/products")
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("aaa"));
        products.add(new Product("bbb"));
        products.add(new Product("ccc"));

        return products;
    }


    @Path("/banner")
    @GET
    @Produces({"image/png"})
    public Response getAsImage() throws WebApplicationException {

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("image1.png");

            return Response.ok().entity(input).build();

        } catch (Exception e) {

            return Response.serverError().build();
        }
    }

}
