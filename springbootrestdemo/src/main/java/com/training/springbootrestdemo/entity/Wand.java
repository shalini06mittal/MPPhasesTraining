package com.training.springbootrestdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "wand")
public class Wand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String wood;
    private String core;
    private String length;

    @OneToOne(mappedBy = "wand")
    @JsonIgnore
    private FictionalCharacter character;

    public Wand() {

    }

    public Wand(String wood, String core, String length) {
        this.wood = wood;
        this.core = core;
        this.length = length;
    }

    public FictionalCharacter getCharacter() {
        return character;
    }

    public void setCharacter(FictionalCharacter character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Wand{" +
                "id=" + id +
                ", wood='" + wood + '\'' +
                ", core='" + core + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}

