package org.ujar.basics.restful.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = Order.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  protected static final String TABLE_NAME = "checkout_orders";

  @Id
  @SequenceGenerator(
      name = "checkout_order_id_seq",
      sequenceName = "checkout_order_id_seq"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "checkout_order_id_seq"
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "order_tracking_number")
  private String orderTrackingNumber;

  @Column(name = "total_quantity")
  private int totalQuantity;

  @Column(name = "total_price")
  private BigDecimal totalPrice;

  @Column(name = "status")
  private String status;

  @Column(name = "date_created")
  @CreationTimestamp
  private Date dateCreated;

  @Column(name = "last_updated")
  @UpdateTimestamp
  private Date lastUpdated;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private Set<OrderItem> orderItems = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
  private Address shippingAddress;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
  private Address billingAddress;

  public void add(OrderItem item) {

    if (item != null) {
      if (orderItems == null) {
        orderItems = new HashSet<>();
      }

      orderItems.add(item);
      item.setOrder(this);
    }
  }

  @Override
  public String toString() {
    return "Order{" +
           "id=" + id +
           ", orderTrackingNumber='" + orderTrackingNumber + '\'' +
           ", totalQuantity=" + totalQuantity +
           ", totalPrice=" + totalPrice +
           ", status='" + status + '\'' +
           ", dateCreated=" + dateCreated +
           ", lastUpdated=" + lastUpdated +
           ", orderItems=" + orderItems +
           ", customer=" + customer +
           ", shippingAddress=" + shippingAddress +
           ", billingAddress=" + billingAddress +
           '}';
  }
}









