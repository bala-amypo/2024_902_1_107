package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;

    public Parcel() {}

    public Parcel(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Long getId() { return id; }
    public String getTrackingNumber() { return trackingNumber; }

    public void setId(Long id) { this.id = id; }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
