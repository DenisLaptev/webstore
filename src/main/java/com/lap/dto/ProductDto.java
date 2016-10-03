package com.lap.dto;

/**
 * Created by lapte on 14.07.2016.
 */
public class ProductDto {
    private Long id;
    private String shortName;
    private String description;
    private int count;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
