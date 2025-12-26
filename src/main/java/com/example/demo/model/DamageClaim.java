package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String status;

    @ManyToOne
    private Parcel parcel;

    public DamageClaim() {}

    public DamageClaim(Long id, String description, String status, Parcel parcel) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.parcel = parcel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }
}
