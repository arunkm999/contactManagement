package com.arun;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.util.*;

@Path("contacts")
public class contacts {

    contactRepository contactRepositoryObj = new contactRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<contactInformation> getContacts(){

        return contactRepositoryObj.getAllContacts();

    }

    @GET
    @Path("contactName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public contactInformation getContacts(@PathParam("name") String name){

      return  contactRepositoryObj.getContact(name);

    }



    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addContact(contactInformation contact){

        contactRepositoryObj.addContact(contact);

        return "Success";

    }

    @PUT
    @Path("modify")
    @Consumes(MediaType.APPLICATION_JSON)
    public String modifyContact(contactInformation contact){

        contactRepositoryObj.updateContact(contact);

        return "Success";

    }


    @DELETE
    @Path("remove/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeContacts(@PathParam("name") String name){

        contactRepositoryObj.deleteContact(name);

        return  "Delete Success";

    }

}
