package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarSearchListDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequest;

import java.util.List;

public interface CarService {
	DataResult<List<CarSearchListDto>> getAll();
	//DataResult<List<CarSearchListDto>> getAllAvailableCars();
	Result add(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);
	//DataResult<List<CarDetail>> getCarsWithBrandAndColorDetails();
	///DataResult<List<CarDetail>> getCarByBrandId(int brandId);
	//DataResult<List<CarDetail>> getCarByColorId(int colorId);
	//DataResult<List<CarSearchListDto>> getCarByCityId(int cityId);
	//DataResult<CarSearchListDto> getById(int id);
	//DataResult<List<CarDetailDto>> getByCarAllDetail(int carId);
	//Result checkIfCarExists(int carId);
	//Result checkIfExistsColorInCar(int colorId);
	//Result checkIfExistsBrandInCar(int brandId);
	//Result updateCarCity(int carId,int cityId);
	//Result updateCarKm(int carId,String kilometer);
}
