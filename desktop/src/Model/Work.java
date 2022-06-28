package Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Work {

    private Integer id;
    private Integer id_cliente;
    private List<Integer> id_func;
    private Double hours;
    private Double price;

    // Constructors

    public Work(Integer id, Integer id_cliente, Double hours, Double price){ 
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_func = new ArrayList<>();
        this.hours = hours;
        this.price = price;
    }

    public Work(Integer id, Integer id_cliente, Integer id_func, Double hours, Double price){ 
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_func = new ArrayList<>();
        this.id_func.add(id_func);
        this.hours = hours;
        this.price = price;
    }

    public Work(Integer id, Integer id_cliente, List<Integer> id_func, Double hours, Double price){ 
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_func = id_func.stream().collect(Collectors.toList());
        this.hours = hours;
        this.price = price;
    }

    // Setters

    public void setId(Integer id){ this.id = id; }
    public void setId_Cliente(Integer id){this.id_cliente = id;}
    public void setId_func(Integer id){if(!this.id_func.contains(id)) this.id_func.add(id); }
    public void setId_func(List<Integer> ids){for(Integer id:ids) if(!this.id_func.contains(id)) this.id_func.add(id);}
    public void setHours(Double hours){this.hours = hours;}
    public void setPrice(Double price){this.price = price;}

    // Getters

    public Integer getId(){return this.id;}
    public Integer getId_Cliente(){return this.id_cliente;}
    public List<Integer> getId_Func(){return this.id_func;}
    public Double getHours(){return this.hours;}
    public Double getPrice(){return this.price;}

}
