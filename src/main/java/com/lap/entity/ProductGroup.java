package com.lap.entity;

import java.util.List;

/**
 * Created by lapte on 14.07.2016.
 */
public class ProductGroup {
    private Long id;
    private String shortName;
    private String description;
    private String PGhref;

    //private List<Product> products;


    public ProductGroup() {
    }

    public ProductGroup(String shortName, String description) {
        setShortName(shortName);
        setDescription(description);
    }

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

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
