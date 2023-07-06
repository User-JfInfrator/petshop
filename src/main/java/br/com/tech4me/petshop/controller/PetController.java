package br.com.tech4me.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.petshop.service.PetService;
import br.com.tech4me.petshop.shared.PetDto;
import br.com.tech4me.petshop.shared.PetListagemDto;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService servico;

    @GetMapping
    public ResponseEntity<List<PetListagemDto>> obterTodosPet(){
        return new ResponseEntity<> (servico.obterTodosPet(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> obterPetPorId(@PathVariable String id){
        Optional<PetDto> pet = servico.obterPetPorId(id);

        if(pet.isPresent()){
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<PetDto> cadastrar(@RequestBody PetDto pet){
        return new ResponseEntity<>(servico.cadastrar(pet), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> atualizarPeloId(@PathVariable String id, @RequestBody PetDto pet){
        Optional<PetDto> petAtualizado = servico.atualizarPeloId(id, pet);

        if(petAtualizado.isPresent()){
            return new ResponseEntity<>(petAtualizado.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
