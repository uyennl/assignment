/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author PC
 */
/*
    create table orders
(
	idOrder int primary key identity(1,1),
	dateOfOrder date not null,
	idCustomer int,
	constraint fk_orders_customer foreign key (idCustomer) REFERENCES customer(idCustomer)
);
 */
public class Order {
    private int idOrder;
    private Date dateOfOrder;
    private Customer idCustomer;
    
    public Order(){
        
    }

    public Order(int idOrder, Date dateOfOrder, Customer idCustomer) {
        this.idOrder = idOrder;
        this.dateOfOrder = dateOfOrder;
        this.idCustomer = idCustomer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", dateOfOrder=" + dateOfOrder + ", idCustomer=" + idCustomer + '}';
    }
    
    
}
