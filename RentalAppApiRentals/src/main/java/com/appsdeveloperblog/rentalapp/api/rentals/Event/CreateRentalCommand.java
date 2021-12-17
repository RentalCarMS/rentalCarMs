package com.appsdeveloperblog.rentalapp.api.rentals.Event;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateRentalCommand {

    @TargetAggregateIdentifier
    private final String rentalEventId;
    private final int carId;
    private final double price;
    private final int totalDays;
    private final String description;
}
