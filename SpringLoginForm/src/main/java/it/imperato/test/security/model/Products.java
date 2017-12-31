package it.imperato.test.security.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = Products.FIND_BY_NAME, query = Products.FIND_BY_NAME_QUERY),
        @NamedQuery(name = Products.FIND_BY_CATEGORY_WITH_LIMIT,query = Products.FIND_BY_CATEGORY_WITH_LIMIT_QUERY)
})
public class Products extends BaseEntity implements Serializable {

    public static final String FIND_BY_NAME="Products.findByName";
    public static final String FIND_BY_NAME_QUERY="FROM Products p WHERE p.name= :name";

    public static final String FIND_BY_CATEGORY_WITH_LIMIT="Products.findByCategoryWithLimit";
    public static final String FIND_BY_CATEGORY_WITH_LIMIT_QUERY="FROM Products p WHERE p.category= :category";

    @Id
    @GeneratedValue
    @Column(name = "idproducts")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "proutes")
    private String proutes;

    ///Add some change
    @Column(name = "category")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProutes() {
        return proutes;
    }

    public void setProutes(String proutes) {
        this.proutes = proutes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (price != products.price) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
