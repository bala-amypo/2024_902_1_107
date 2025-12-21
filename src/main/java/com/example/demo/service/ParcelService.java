package com.example.demo.service;

import com.example.demo.model.Parcel;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {

    public Parcel addParcel(Parcel parcel) {
        return parcel;
    }

    public Parcel getByTrackingNumber(String trackingNumber) {
        return null;
    }
}
