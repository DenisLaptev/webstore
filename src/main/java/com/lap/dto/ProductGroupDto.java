package com.lap.dto;


/**
 * Created by lapte on 14.07.2016.
 */
public class ProductGroupDto {
    private Long id;
    private String shortName;
    private String description;

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
                '}';
    }
}
