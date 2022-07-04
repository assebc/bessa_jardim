package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cliente {

    private Integer id;

    private String name;

    private String morada;

    private String cod_postal;

    private Map<Integer, List<Work>> trabalhos;

    // Constructors
    
    // TODO: falta construtores

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMorada(String name){
        this.morada = morada;
    }

    public void setCod_Postal(String asd){
        this.cod_postal = asd;
    }
    
    public void setTrabalhos(Map<Integer, List<Work>> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public void setTrabalhos(int id, List<Work> trabalho){
        if(this.trabalhos.containsKey(id)) this.trabalhos.put(id,trabalho);
        else {
            for(Work w: trabalho){
                this.setTrabalho(id, w);
            }
        }
    }

    public void setTrabalho(int id, Work w){
        this.trabalhos.getOrDefault(id,new ArrayList<>()).add(w);
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMorada(){ return morada; }

    public String getCod_Postal(){ return cod_postal;}

    public Map<Integer, List<Work>> getTrabalhos() {
        return trabalhos;
    }

    // Queries

    public Double payment(){
        List<Work> works = getTrabalhos().values().stream().map(l->l.stream().iterator().next()).collect(Collectors.toList());
        double pay = 0.0;
        for(Work w:works){pay+=w.payForWork();}
        return pay;
    }
}
