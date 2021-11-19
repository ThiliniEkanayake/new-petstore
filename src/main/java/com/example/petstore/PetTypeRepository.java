package com.example.petstore;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

//public class PetRepository {



@ApplicationScoped
public class PetTypeRepository implements PanacheRepository<PetType> {

    // put your custom logic here as instance methods

//        public Pet findByName(String name){
//            return find("name", name).firstResult();
//        }

//        public List<Pet> findAlive(){
//            return list("status", Status.Alive);
//        }
//
//        public void deleteStefs(){
//            delete("name", "Stef");
//        }
}
//}
