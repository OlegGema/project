//package ua.com.owu.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Item {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    private int quality;
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Busket busket;
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Product>products;
//
//    public Item() {
//    }
//
//    public int getQuality() {
//        return quality;
//    }
//
//    public void setQuality(int quality) {
//        this.quality = quality;
//    }
//
//    public Busket getBusket() {
//        return busket;
//    }
//
//    public void setBusket(Busket busket) {
//        this.busket = busket;
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", quality=" + quality +
//                '}';
//    }
//}
