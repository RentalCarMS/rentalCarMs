package com.appsdeveloperblog.rentalapp.api.rentals.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int carId;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "dailyPrice")
    private int dailyPrice;
    

    @Column(name = "description")
    private String description;
   
    @ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand; 
	
	@ManyToOne 
	@JoinColumn(name="color_id")
	private Color color;


}
