package com.adriano.helpedesk.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Cliente  extends  Pessoa{

    private List<Chamado> chamados = new ArrayList<>();


}
