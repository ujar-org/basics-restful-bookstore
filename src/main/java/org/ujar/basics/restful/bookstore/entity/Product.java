package org.ujar.basics.restful.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@Table(name = Product.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  protected static final String TABLE_NAME = "bookstore_products";

  @Id
  @SequenceGenerator(
      name = "product_id_seq",
      sequenceName = "product_id_seq"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "product_id_seq"
  )
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private ProductCategory category;

  @Column(name = "sku")
  private String sku;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "unit_price")
  private BigDecimal unitPrice;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "active")
  private boolean active;

  @Column(name = "units_in_stock")
  private int unitsInStock;

  @CreatedDate
  @Column(name = "created_at")
  @JsonProperty("created_at")
  private Instant createdAt;

  @Override
  public String toString() {
    return "Product{" +
           "id=" + id +
           ", category=" + category +
           ", sku='" + sku + '\'' +
           ", name='" + name + '\'' +
           ", description='" + description + '\'' +
           ", unitPrice=" + unitPrice +
           ", imageUrl='" + imageUrl + '\'' +
           ", active=" + active +
           ", unitsInStock=" + unitsInStock +
           ", createdAt=" + createdAt +
           '}';
  }
}
