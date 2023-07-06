package br.com.tech4me.petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.petshop.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {
    
}
