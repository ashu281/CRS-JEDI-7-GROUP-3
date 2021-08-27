package com.flipkart.restController;

import com.flipkart.bean.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;


/**
 * @author Amit
 */
//rest service here  http://localhost:8080/REST-jersey/customer/json
@Path("/customer")
public class CustomerRestController {

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerDetails() {

        //  clinet --- service ---- dao ----> SQL

        Customer customer = new Customer();
        customer.setCustomerID(101);
        customer.setCustomerName("Flipkart");
        customer.setCustomerAddress("mumbai");

        return customer;
    }


//    @GET
//    @Path("/xml")
//    @Produces(MediaType.APPLICATION_XML)
//    public Response getCustomerDetailsXML() {
//
//        //  clinet --- service ---- dao ----> SQL
//
//        CustomerXML customer = new CustomerXML();
//        customer.setId(101);
//        customer.setName("Flipcard");
//        customer.setAddress("mumbai");
//
//        return Response.status(200)
//                .entity(customer).build();
//
//    }

    //
    @POST
    @Path("/post")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Customer customer) {
        System.out.println("hit post service");

        System.out.println("value of title from UI " + customer.getCustomerID());
        System.out.println("value of singer form UI" + customer.getCustomerName());


        String result = "Track saved : " + customer;


        return Response.status(201).entity(result).build();

    }

    //
//
//    // delete operation
//
//
    @DELETE
    @Path("/delete/{customerId}")
    public Response deleteCustomer(@PathParam("customerId") int customerId)
            throws URIReferenceException {

        // service query to perfomr the delete operation

        // implementation
        return Response.status(200).entity("customer id " + customerId +
                "successfully deleted").build();


    }

    //
//
    @PUT
    @Path("/update")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer updateCustomer(Customer customer) {

        // rest of impl write here in code

        customer.setCustomerName(customer.getCustomerName() + "updated");
        return customer;

    }
}