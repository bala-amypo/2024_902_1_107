package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repo;

    public ParcelServiceImpl(ParcelRepository repo) {
        this.repo = repo;
    }

    public Parcel add(Parcel parcel) {
        if (repo.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("tracking exists");
        }
        return repo.save(parcel);
    }
}
