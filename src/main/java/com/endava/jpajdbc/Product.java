package com.endava.jpajdbc;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "retailer_country")
    private String ratailerCountry;

    @Column(name = "order_method_type")
    private String orderMethodType;

    @Column(name = "product_line")

    private String productLine;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_year")
    private String productYear;

    @Column(name = "quarter_year")
    private String quarterYear;

    private Integer quantity;

    public Product(String ratailerCountry, String orderMethodType, String productLine, String productType, String productName, String productYear, String quarterYear, Integer quantity) {
        this.ratailerCountry = ratailerCountry;
        this.orderMethodType = orderMethodType;
        this.productLine = productLine;
        this.productType = productType;
        this.productName = productName;
        this.productYear = productYear;
        this.quarterYear = quarterYear;
        this.quantity = quantity;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRatailerCountry() {
        return ratailerCountry;
    }

    public void setRatailerCountry(String ratailerCountry) {
        this.ratailerCountry = ratailerCountry;
    }

    public String getOrderMethodType() {
        return orderMethodType;
    }

    public void setOrderMethodType(String orderMethodType) {
        this.orderMethodType = orderMethodType;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    public String getQuarterYear() {
        return quarterYear;
    }

    public void setQuarterYear(String quarterYear) {
        this.quarterYear = quarterYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
