package com.appsdeveloperblog.rentalapp.api.rentals.controllers;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.CarService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarSearchListDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	private CarService carService;

	@Autowired
	private CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	@GetMapping("check")
	public String check() {
		return "Work on ";
	}
	@GetMapping("getAll")
	public DataResult<List<CarSearchListDto>> getAll() {
		return carService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}

	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
	/*@GetMapping("getAllAvailableCars")
	public DataResult<List<CarSearchListDto>> getAllAvailableCars() {
		return carService.getAllAvailableCars();
	}

	@GetMapping("getCarsDetail")
	public DataResult<List<CarDetail>> getCarsWithBrandAndColorDetails() {
		return carService.getCarsWithBrandAndColorDetails();
	}
	@GetMapping("getCityId")
	public DataResult<List<CarSearchListDto>> getCarByCityId(int cityId){
		return carService.getCarByCityId(cityId);
	}

	@GetMapping("getBrandDetail")
	public DataResult<List<CarDetail>> getCarsWithBrandId(int brandId) {
		return carService.getCarByBrandId(brandId);
	}

	@GetMapping("getColorDetail")
	public DataResult<List<CarDetail>> getCarsWithColorId(int colorId) {
		return carService.getCarByColorId(colorId);
	}

	@GetMapping("getImageDetail")
	public DataResult<List<CarDetailDto>> getCarWithImageDetail(int carId) {
		return carService.getByCarAllDetail(carId);
	}

	@GetMapping("getbyId")
	public DataResult<CarSearchListDto> getByCarId(int carId) {
		return carService.getById(carId);
	}*/
}
