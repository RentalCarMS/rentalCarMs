package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequest;

import java.util.List;

public interface ColorService {
	DataResult<List<Color>> getAll();
	Result add(CreateColorRequest createColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
	//Result checkIfColorExists(int colorId);
}
