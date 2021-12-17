package com.appsdeveloperblog.rentalapp.api.rentals.Event;


import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/eventrental")
public class RentalEvnetController {
    private CommandGateway commandGateway;

    @Autowired
    public RentalEvnetController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createRental(@RequestBody CreateRentalRestModel createRentalRestModel ){

    CreateRentalCommand command = CreateRentalCommand.builder()
            .price(createRentalRestModel.getPrice())
            .carId(createRentalRestModel.getCarId())
            .totalDays(createRentalRestModel.getTotalDays())
            .description(createRentalRestModel.getDescription())
            .rentalEventId(UUID.randomUUID().toString()).build();

     String returnValue = this.commandGateway.sendAndWait(command);

    return returnValue;
    }



}
