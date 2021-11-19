package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Schema(name = "PetType")
@Entity
public class PetType {

    @Schema(required = true, description = "Pet Type id")
    @JsonProperty("pet_type_id")
    @Id @GeneratedValue
    private Long petTypeId;

    @Schema(required = true, description = "Pet type")
    @JsonProperty("pet_type")
    private String petType;

    public Long getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Long petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
//	public Long getPetId() {
//		return petId;
//	}
//
//	public void setPetId(Long petId) {
//		this.petId = petId;
//	}
//
//	public String getPetType() {
//		return petType;
//	}
//
//	public void setPetType(String petType) {
//		this.petType = petType;
//	}
//
//	public String getPetName() {
//		return petName;
//	}
//
//	public void setPetName(String petName) {
//		this.petName = petName;
//	}
//
//	public Integer getPetAge() {
//		return petAge;
//	}
//
//	public void setPetAge(Integer petAge) {
//		this.petAge = petAge;
//	}

}
