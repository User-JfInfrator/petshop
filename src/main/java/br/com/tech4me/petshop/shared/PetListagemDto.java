package br.com.tech4me.petshop.shared;

import java.util.List;

public record PetListagemDto(String id, String nome, List<String> procedimentos) {
    
}
