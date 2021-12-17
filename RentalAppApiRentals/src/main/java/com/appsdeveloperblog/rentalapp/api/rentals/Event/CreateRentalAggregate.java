package com.appsdeveloperblog.rentalapp.api.rentals.Event;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateRentalAggregate {;

    @AggregateIdentifier
    private  String rentalEventId;
    private  int carId;
    private double price;
    private int totalDays;
    private String description;

    public CreateRentalAggregate(){

    }
    @CommandHandler
    public CreateRentalAggregate(CreateRentalCommand createRentalCommand){
        if(createRentalCommand.getPrice()<0){
            throw new IllegalArgumentException("price is not bigger than zero");

        }

        RentalCreatedEvent rentalCreatedEvent = new RentalCreatedEvent();

        BeanUtils.copyProperties(createRentalCommand,rentalCreatedEvent);
        AggregateLifecycle.apply(rentalCreatedEvent);


    }

    @EventSourcingHandler
    public void on(RentalCreatedEvent createdEvent){
        this.carId=createdEvent.getCarId();
        this.rentalEventId=createdEvent.getRentalEventId();
         this.description=createdEvent.getDescription();
         this.price=createdEvent.getPrice();
         this.totalDays=createdEvent.getTotalDays();



    }

}
