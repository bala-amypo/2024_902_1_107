package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private double amount;

    public DamageClaim() {}

    public DamageClaim(Parcel parcel, double amount) {
        this.parcel = parcel;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public Parcel getParcel() { return parcel; }
    public double getAmount() { return amount; }

    public void setId(Long id) { this.id = id; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }
    public void setAmount(double amount) { this.amount = amount; }
}
