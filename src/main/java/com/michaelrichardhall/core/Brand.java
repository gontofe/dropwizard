package com.michaelrichardhall.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Brand {

    private Long id;
    private String name;

    public Brand(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(getId(), brand.getId()) && Objects.equals(getName(), brand.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
