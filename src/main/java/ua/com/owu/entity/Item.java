package ua.com.owu.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "busket_item",
            inverseJoinColumns = @JoinColumn(name = "Busket_id"),
            joinColumns = @JoinColumn(name = "items_itemId"))
    private Busket busket;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;

    public Item() {
    }

    public int getItemId() {
        return itemId;
    }

    public Busket getBusket() {
        return busket;
    }

    public void setBusket(Busket busket) {
        this.busket = busket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                '}';
    }
}
