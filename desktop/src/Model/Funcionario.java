package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcionario{

    private Integer id;
    private String name;
    private Double hours;
    private Double hours_left;
    private Integer price;
    private List<Integer> clients;
    private Integer num_works;

    // Constructors

    public Funcionario(String name, int price) {
        this.name = name;
        this.hours = 0.0;
        this.hours_left = 0.0;
        this.price = price;
        this.clients = new ArrayList<>();
        this.num_works = 0;
    }

    // Setters

    public void setId(Integer id){
        this.id = id;
    }
    
    public void setName(String name) {
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

    public void setPrice(Integer price) {
        this.price = price;
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

    public void setNum_works() {
        if(LocalDateTime.now().getDayOfMonth()!= 1)this.num_works++;
        else this.num_works = 1;
    }

    // Getters

    public Integer getId(){
        return id;
    }
    
    public String getName() {
        return name;
    }

    public Double getHours() {
        return hours;
    }

    public Double getHours_left() {
        return hours_left;
    }

    public Integer getPrice() {
        return price;
    }

    public List<Integer> getClients() {
        return clients;
    }

    public Integer getNum_works() {
        return num_works;
    }

    // queries

    public Integer num_clients(){
        return getClients().size();
    }

    public Double late_payment(){
        return getHours_left()*getPrice();
    }

    public Double payment(){
        return getHours_left()*getPrice();
    }

    public Double total_payment(){
        return (getHours_left()+getHours())*getPrice();
    }

    public Double payTotal(){
        double pay = total_payment();
        this.hours_left = 0.0;
        this.hours = 0.0;
        return pay;
    }

    public Double paySomeHours(double hours){
        double pay = hours;
        if(getHours_left()!=0){
            if(hours>getHours_left()){
                hours -= this.hours_left;
                this.hours_left = 0.0;
                this.hours -= hours;
            } else this.hours_left -= hours;
        } else{
            this.hours -= hours;
        }
        return pay*getPrice();
    }

    public void addWork(Cliente c, double hours){
        setNum_works();
        setClient(c);
        setHours(hours);
    }


}