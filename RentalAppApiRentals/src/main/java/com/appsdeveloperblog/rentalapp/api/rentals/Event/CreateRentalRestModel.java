package com.appsdeveloperblog.rentalapp.api.rentals.Event;


import lombok.Data;

@Data
public class CreateRentalRestModel{


    private int carId;
    private double price;
    private int totalDays;
    private String description;
}
