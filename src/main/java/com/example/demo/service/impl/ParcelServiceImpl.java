package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepo;

    public ParcelServiceImpl(ParcelRepository parcelRepo) {
        this.parcelRepo = parcelRepo;
    }

    @Override
    public Parcel addParcel(Parcel p) {
        if (parcelRepo.existsByTrackingNumber(p.getTrackingNumber())) {
            throw new RuntimeException("Tracking number already exists");
        }
        return parcelRepo.save(p);
    }

    @Override
    public Parcel getByTrackingNumber(String tn) {
        return parcelRepo.findByTrackingNumber(tn)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
    }
}
