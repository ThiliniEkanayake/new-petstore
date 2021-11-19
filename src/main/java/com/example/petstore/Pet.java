package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Schema(name = "Pet")
@Entity
public class Pet {

	@Schema(required = true, description = "Pet id")
	@JsonProperty("pet_id")
	@Id @GeneratedValue
	private Long petId;

	@Schema(required = true, description = "Pet type")
	@JsonProperty("pet_type")
	private String petType;

	@Schema(required = true, description = "Pet name")
	@JsonProperty("pet_name")
	private String petName;

	@JsonProperty("pet_age")
	private Long petAge;

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Long getPetAge() {
		return petAge;
	}

	public void setPetAge(Long petAge) {
		this.petAge = petAge;
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
