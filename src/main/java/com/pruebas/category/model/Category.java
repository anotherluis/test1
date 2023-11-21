package com.pruebas.category.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    // **declaraciones de variables en el modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // **! Constructor vacío necesario para JPA
    public Category() {
    }

    // **! Constructor con parámetros
    public Category(String name) {
        this.name = name;
    }

    // ** Getters y setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // **? toString para facilitar la depuración
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Category category() {
        return null;
    }

}
