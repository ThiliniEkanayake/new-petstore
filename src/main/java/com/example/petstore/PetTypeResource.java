package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Consumes("/")
@Path("/v1/pettype")
@Produces("application/json")
public class PetTypeResource {

    private static List<PetType> pettype = new ArrayList<>();
//    private static List<Pet> pets = new ArrayList<>();

    //Get All Pet Types
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All Pet Types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType")))})
    @GET
    public Response getPetTypes() {
        List<PetType> allPetTypes = new ArrayList<PetType>();
//        List<Pet> allPets = new ArrayList<Pet>();

        if(pettype.size() > 0){
            for(int i=0; i< pettype.size(); i++){
                PetType petType = new PetType();

                petType.setPetTypeId(pettype.get(i).getPetTypeId());
                petType.setPetType(pettype.get(i).getPetType());

                allPetTypes.add(i, petType);
            }
        }
        return Response.ok(allPetTypes).build();
    }


    //Add a New Pet Type
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Pet Type Added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType")))})
    @POST
    @Path("/addpetype")
    public Response createPetTypes(PetType petType) {
        int newPetTypeId = 0;
        if(pettype.isEmpty()) {
            newPetTypeId = 1;
        } else {
            newPetTypeId = (int) (pettype.get(pettype.size()-1).getPetTypeId()+1);
        }

        petType.setPetTypeId((long) newPetTypeId);
        petType.setPetType(petType.getPetType());

        pettype.add(petType);
        return Response.ok(petType).build();
    }


    //Find a Pet Type from petTypeId
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "The Pet Type found Successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for the given id.")})
    @GET
    @Path("/findpettype/{petTypeId}")
    public Response getPetType(@PathParam("petTypeId") int petTypeId) {
        int value = -1;
        if(pettype.size() > 0 && petTypeId > 0){
            for(int i=0; i< pettype.size(); i++){
                if(pettype.get(i).getPetTypeId() == petTypeId){
                    value = i;
                }
            }
        }
        PetType petType = new PetType();
        if(value != -1){
            petType.setPetTypeId(pettype.get(value).getPetTypeId());
            petType.setPetType(pettype.get(value).getPetType());
        } else {
            return Response.status(404).build();
        }
        return Response.ok(petType).build();
    }


    //Update an existing Pet Type from Pet TypeID
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type Updated Successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for the given id.")})
    @PUT
    @Path("/updatepettype/{petTypeId}")
    public Response updatePetType(@PathParam("petTypeId") int petTypeId, PetType petType) {
        int value = -1;
        if(pettype.size() > 0 && petTypeId > 0){
            for(int i=0; i< pettype.size(); i++){
                if(pettype.get(i).getPetTypeId() == petTypeId){
                    value = i;
                }
            }
        }
        PetType exPetType = pettype.get(value);
        if(value != -1){
            exPetType.setPetType(petType.getPetType());
        } else {
            return Response.status(404).build();
        }
        return Response.ok(exPetType).build();
    }


    //Delete an existing pet
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type Deleted Successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for the given id.")})
    @DELETE
    @Path("/deletepettype/{petTypeId}")
    public Response deletePetType(@PathParam("petTypeId") int petTypeId) {
        int value = -1;
        if(pettype.size() > 0 && petTypeId > 0){
            for(int i=0; i< pettype.size(); i++){
                if(pettype.get(i).getPetTypeId() == petTypeId){
                    value = i;
                }
            }
        }
        if(value != -1){
            pettype.remove(value);
        } else {
            return Response.status(404).build();
        }
        return Response.status(200).build();
    }
}



//
//		Pet pet1 = new Pet();
////		pet1.setPetId(1);
////		pet1.setPetAge(3);
////		pet1.setPetName("Boola");
////		pet1.setPetType("Dog");
//
//		Pet pet2 = new Pet();
////		pet2.setPetId(2);
////		pet2.setPetAge(4);
////		pet2.setPetName("Sudda");
////		pet2.setPetType("Cat");
//
//		Pet pet3 = new Pet();
////		pet3.setPetId(3);
////		pet3.setPetAge(2);
////		pet3.setPetName("Peththappu");
////		pet3.setPetType("Bird");
//
//		pets.add(pet1);
//		pets.add(pet2);
//		pets.add(pet3);
//		return Response.ok(pets).build();



//	}
//
//	@APIResponses(value = {
//			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
//			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
//	@GET
//	@Path("{petId}")
//	public Response getPet(@PathParam("petId") int petId) {
//		if (petId < 0) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		Pet pet = new Pet();
////		pet.setPetId(petId);
////		pet.setPetAge(3);
////		pet.setPetName("Buula");
////		pet.setPetType("Dog");
//
//		return Response.ok(pet).build();
//
//	}
//}
