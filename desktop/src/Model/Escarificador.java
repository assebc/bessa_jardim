package Model;

import java.util.List;

public class Escarificador extends Work{

    // Constructors

    public Escarificador(Integer id, Integer id_cliente, List<Integer> id_func, Double hours, Double price) {
        super(id, id_cliente, id_func, hours, price);
    }

    public Escarificador(Integer id, Integer id_cliente, Double hours, Double price) {
        super(id, id_cliente, hours, price);
    }

    public Escarificador(Integer id, Integer id_cliente, Integer id_func, Double hours, Double price) {
        super(id, id_cliente, id_func, hours, price);
    }

    // Setters

    @Override
    public void setHours(Double hours) {
        super.setHours(hours);
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public void setId_Cliente(Integer id) {
        super.setId_Cliente(id);
    }

    @Override
    public void setId_func(Integer id) {
        super.setId_func(id);
    }

    @Override
    public void setId_func(List<Integer> ids) {
        super.setId_func(ids);
    }

    @Override
    public void setPrice(Double price) {
        super.setPrice(price);
    }

    // Getters

    @Override
    public Double getHours() {
        return super.getHours();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public Integer getId_Cliente() {
        return super.getId_Cliente();
    }

    @Override
    public List<Integer> getId_Func() {
        return super.getId_Func();
    }

    @Override
    public Double getPrice() {
        return super.getPrice();
    }

    // Defaults

    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Queries
    

    @Override
    public Double payForWork() {
        return super.payForWork();
    }


}
