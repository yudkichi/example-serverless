package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

@Data
class Estado{
    private Long id;
    private String nomeEstado; 
    
    public Estado(Long id, String nomeEstado){
        this.id = id;
        this.nomeEstado = nomeEstado;
    }
}

@Data
class Cidade{
    private Long id;
    private String nomeCidade;
    private Estado estado;
    
    public Cidade(Long id, String nomeCidade, Estado estado){
        this.id = id;
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }
}

public class Function {
    
    @FunctionName("criarcidade")
    public Cidade create (
        @HttpTrigger(
            name = "restcriarcidade",
            methods = {HttpMethod.POST},
            route = "cidade"
        ) Cidade cidade) {
        return cidade;
    }
    
    @FunctionName("alteracidade")
    public Cidade update (
        @HttpTrigger(
            name = "restalteracidade",
            methods = {HttpMethod.PUT},
            route = "cidade"
        ) Cidade cidade) {
        return cidade;
    }

    @FunctionName("lercidades")
    public List<Cidade> read(
        @HttpTrigger(
            name = "restlercidades",
            methods = {HttpMethod.GET},
            route = "cidade"
        )String x) {
	List<Cidade> listaCidades = new ArrayList<>();
        Estado sp = new Estado(new Long(1), "São paulo");
        Estado pr = new Estado(new Long(2), "Paraná");
        Estado ms = new Estado(new Long(3), "Mato Grosso do Sul");
        Cidade saoPaulo = new Cidade(new Long(40), "São Paulo", sp);
        Cidade londrina = new Cidade(new Long(21), "Londrina", pr);
        Cidade tl = new Cidade(new Long(34), "Três Lagoas", ms);
        cidades.add(saoPaulo);
        cidades.add(londrina);
        cidades.add(tl);
        return listaCidades;
    }
        
    @FunctionName("apagarcidade")
    public int delete (
        @HttpTrigger(
            name = "restapagarcidade",
            methods = {HttpMethod.DELETE},
            route = "cidade/{id}"
        )@BindingName("id") Long id) {
        return 200;
    }

}
