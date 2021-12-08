package com.appsdeveloperblog.rentalapp.api.rentals.dataAccess;

import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color, Integer> {

	//boolean existsById(int colorId);
	boolean existsByColorName(String colorName);
}
