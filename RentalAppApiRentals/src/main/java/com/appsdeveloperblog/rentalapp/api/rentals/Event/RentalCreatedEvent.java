package com.appsdeveloperblog.rentalapp.api.rentals.Event;

import lombok.Data;

@Data
public class RentalCreatedEvent {
    private  String rentalEventId;
    private  int carId;
    private  double price;
    private  int totalDays;
    private  String description;
}
