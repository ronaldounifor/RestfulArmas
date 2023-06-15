package com.pas.armas;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/armas")
public class ArmaController {
    private ArrayList<Arma> armas = new ArrayList<>();

    @GetMapping
    public String getArmas() {
        return armas.toString();
    }

    @GetMapping(path="/{nome}")
    public Arma getArma(@PathVariable String nome) {
        Arma arma = new Arma();
        arma.setNome(nome);

        return armas.get(armas.indexOf(arma));
    }
    
    @PostMapping
    public String adicionarArma(@RequestBody Arma arma) {
        armas.add(arma);
        return "Adicionado com sucesso";
    }

    @PutMapping(path="/{nome}")
    public String atualizarArma(@RequestBody Arma armaNova, @PathVariable String nome) {
        Arma arma = new Arma();
        arma.setNome(nome);

        armas.set(armas.indexOf(arma), armaNova);
        return "Atualizada com sucesso";
    }

    @PatchMapping(path="/{nome}")
    public String atualizarDano(@RequestBody Arma armaNova, @PathVariable String nome) {
        Arma armaAntiga = getArma(nome);

        armaAntiga.setDano(armaNova.getDano());
        return "Dano atualizado com sucesso";
    }

    @DeleteMapping(path="/{nome}")
    public String deletarArma(@PathVariable String nome) {
        Arma arma = new Arma();
        arma.setNome(nome);

        armas.remove(arma);

        return nome + " deletado com sucesso!";
    }

}
