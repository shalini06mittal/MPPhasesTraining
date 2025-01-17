package com.training.springbootrestdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class FictionalCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150, unique = true)
    private String name;
    @Column(length = 150, nullable = false)
    private String house;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="wandid")
    private Wand wand;
    @Column(length = 150, nullable = false)
    private String bio;
    private String imageurl;

    public FictionalCharacter() {

    }

    public FictionalCharacter(String name, String house, Wand wand, String bio, String imageurl) {
        this.name = name;
        this.house = house;
        this.wand = wand;
        this.bio = bio;
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "FictionalCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", house='" + house + '\'' +
                ", bio='" + bio + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }

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

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}
