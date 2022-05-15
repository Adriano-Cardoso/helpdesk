package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
public class Cliente  extends  Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente (){
        addPerfil(Perfil.CLIENTE);
    }



}
