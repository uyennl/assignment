/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author PC
 */
/*
    id int primary key identity(1,1),
	typePayment varchar(100) not null,
	quantity int not null,
	idDish int,
	idOrder int,
	constraint fk_order_dish foreign key (idDish) references dish(idDish),
	constraint fk_order_orderdetails foreign key (idOrder) references orders(idOrder)
);
*/
public class OrderDetails {
    private int id;
    private String typePayMent;
    private int quantity;
    private Dish dish;
    private Order order;
    
    public OrderDetails(){
        
    }

    public OrderDetails(int id, String typePayMent, int quantity, Dish dish, Order order) {
        this.id = id;
        this.typePayMent = typePayMent;
        this.quantity = quantity;
        this.dish = dish;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePayMent() {
        return typePayMent;
    }

    public void setTypePayMent(String typePayMent) {
        this.typePayMent = typePayMent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", typePayMent=" + typePayMent + ", quantity=" + quantity + ", dish=" + dish + ", order=" + order + '}';
    }
    
    
}
