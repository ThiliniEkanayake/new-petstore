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
@Path("/v1/pets")
@Produces("application/json")
public class PetResource {

	private static List<Pet> pets = new ArrayList<>();

	//Get All Pets
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
	@GET
	public Response getPets() {
		List<Pet> allPets = new ArrayList<Pet>();
		if(pets.size() > 0){
			for(int i=0; i< pets.size(); i++){
				Pet pet = new Pet();
				pet.setPetId(pets.get(i).getPetId());
				pet.setPetAge(pets.get(i).getPetAge());
				pet.setPetName(pets.get(i).getPetName());
				pet.setPetType(pets.get(i).getPetType());
				allPets.add(i, pet);
			}
		}
		return Response.ok(allPets).build();
	}


	//Add a New Pet
	@APIResponses(value = {
			@APIResponse(responseCode = "201", description = "A New Pet Added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
	@POST
	@Path("/add")
	public Response createPet(Pet pet) {
		int newPetID = 0;
		if(pets.isEmpty()) {
			newPetID = 1;
		} else {
			newPetID = (int) (pets.get(pets.size()-1).getPetId()+1);
		}

		pet.setPetId((long) newPetID);
		pet.setPetAge(pet.getPetAge());
		pet.setPetName(pet.getPetName());
		pet.setPetType(pet.getPetType());
		pets.add(pet);
		return Response.ok(pet).build();
	}


	//Find a pet from petId
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "The Pet found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the given id.")})
	@GET
	@Path("/findpet/{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		int value = -1;
		if(pets.size() > 0 && petId > 0){
			for(int i=0; i< pets.size(); i++){
				if(pets.get(i).getPetId() == petId){
					value = i;
				}
			}
		}
		Pet pet = new Pet();
		if(value != -1){
			pet.setPetId(pets.get(value).getPetId());
			pet.setPetAge(pets.get(value).getPetAge());
			pet.setPetName(pets.get(value).getPetName());
			pet.setPetType(pets.get(value).getPetType());
		} else {
			return Response.status(404).build();
		}
		return Response.ok(pet).build();
	}


	//Update an existing Pet from petId
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "The Pet updated Successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the given id.")})
	@PUT
	@Path("/findpet/{petId}")
	public Response updatePet(@PathParam("petId") int petId, Pet pet) {
		int value = -1;
		if(pets.size() > 0 && petId > 0){
			for(int i=0; i< pets.size(); i++){
				if(pets.get(i).getPetId() == petId){
					value = i;
				}
			}
		}
		Pet exPet = pets.get(value);
		exPet.setPetAge(pet.getPetAge());
		exPet.setPetName(pet.getPetName());
		exPet.setPetType(pet.getPetType());
		return Response.ok(exPet).build();
	}


	//Delete an existing pet
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "The Pet Deleted Succesfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the given id.")})
	@DELETE
	@Path("/deletepet/{petId}")
	public Response deletePet(@PathParam("petId") int petId) {
		int value = -1;
		if(pets.size() > 0 && petId > 0){
			for(int i=0; i< pets.size(); i++){
				if(pets.get(i).getPetId() == petId){
					value = i;
				}
			}
		}
		if(value != -1){
			pets.remove(value);
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
