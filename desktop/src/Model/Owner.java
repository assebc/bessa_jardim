package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Owner {

    private String name;
    private Double hours; // propria
    private Double hours_left; // propria
    private List<Integer> funcionarios;
    private Map<Integer,Work> works;
    private List<Integer> clients; // list de todos os ids de clientes
    private Integer num_works; //  private num_works

    // Constructors
    
    public Owner(String name){
        this.name = name;
        this.hours = 0.0;
        this.hours_left = 0.0;
        this.funcionarios = new ArrayList<>();
        this.works = new HashMap<>();
        this.clients = new ArrayList<>();
        this.num_works = 0;
    }

    // Setters

    public void setName(String name){
        this.name = name;
    }

    public void setHours(Double hours) {
        if(LocalDateTime.now().getDayOfMonth()==1) {
            this.hours_left += getHours();
            this.hours = hours;
        } else this.hours += hours;
    }

    public void setHours_left(Double hours_left) {
        this.hours_left = hours_left;
    }

    public void setFuncionarios(List<Integer> func){
        this.funcionarios = func;
    }
    public void setFuncionario(Funcionario f){
        if(!this.funcionarios.contains(f.getId())) this.funcionarios.add(f.getId());
    }

    public void setFuncionario(Integer id){
        if(!this.funcionarios.contains(id)) this.funcionarios.add(id);
    }

    public void setClients(List<Integer> clients) {
        this.clients = clients;
    }

    public void setClient(Cliente c){
        if(LocalDateTime.now().getDayOfMonth()==1){
            this.clients.clear();
            this.clients.add(c.getId());
        } else if(!(this.clients.contains(c.getId()))) this.clients.add(c.getId());
    }

    public void setClient(Integer id){
        if(LocalDateTime.now().getDayOfMonth()==1){
            this.clients.clear();
            this.clients.add(id);
        } else if(!(this.clients.contains(id))) this.clients.add(id);
    }

    public void setNum_works(Integer num_works) {
        if(LocalDateTime.now().getDayOfMonth()!= 1)this.num_works += num_works;
        else this.num_works = num_works;
    }

    public void setWorks(Map<Integer,Work> works){
        this.works = works;
    }

    

    public void setNum_works() {
        if(LocalDateTime.now().getDayOfMonth()!= 1)this.num_works++;
        else this.num_works = 1;
    }

    // Getters

    // Queries



}
