package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    // ================= CREATE PARCEL =================
    @PostMapping
    public Parcel createParcel(@RequestBody Parcel parcel) {
        return parcelService.createParcel(parcel);
    }

    // ================= GET PARCEL BY ID =================
    @GetMapping("/{id}")
    public Parcel getParcel(@PathVariable Long id) {
        return parcelService.getParcel(id);
    }

    // ================= GET ALL PARCELS =================
    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getAllParcels();
    }
}
