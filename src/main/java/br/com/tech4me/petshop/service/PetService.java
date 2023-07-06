package br.com.tech4me.petshop.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.petshop.shared.PetDto;
import br.com.tech4me.petshop.shared.PetListagemDto;

public interface PetService {
    List<PetListagemDto> obterTodosPet();
    Optional<PetDto> obterPetPorId(String id);
    PetDto cadastrar(PetDto pet);
    Optional<PetDto> atualizarPeloId(String id, PetDto pet);
    void excluirPorId(String id);
}
