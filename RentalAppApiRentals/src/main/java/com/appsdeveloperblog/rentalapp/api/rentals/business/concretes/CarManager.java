package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.BrandService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.CarService;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.ColorService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarSearchListDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.bussines.BusinessRules;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.*;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.CarDao;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Car;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {

    private CarDao carDao;
    private ModelMapperService modelMapperService;

    @Autowired
    private CarManager(CarDao carDao, ModelMapperService modelMapperService) {
        super();
        this.carDao = carDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CarSearchListDto>> getAll() {
        List<Car> result = this.carDao.findAll();
        List<CarSearchListDto> response = result.stream()
                .map(car -> modelMapperService.forDto().map(car, CarSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, "car listed");
    }

  /*  @Override
    public DataResult<List<CarSearchListDto>> getAllAvailableCars() {
        List<CarSearchListDto> result = this.carDao.getAllWithoutMaintenanceOfCar();
        return new SuccessDataResult<List<CarSearchListDto>>(result);
    }*/

    @Override
    public Result add(CreateCarRequest createCarRequest) {
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        this.carDao.save(car);
        return new SuccessResult("car added");
    }

    @Override
    public Result update(UpdateCarRequest updateCarRequest) {
        Result result = BusinessRules.run(checkIfCarExists(updateCarRequest.getCarId()));
        if (result != null) {
            return result;
        }
        Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        carDao.save(car);
        return new SuccessResult("car update");
    }

    @Override
    public Result delete(DeleteCarRequest deleteCarRequest) {
        Result result = BusinessRules.run(checkIfCarExists(deleteCarRequest.getCarId()));
        if (result != null) {
            return result;
        }

        Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
        carDao.delete(car);
        return new SuccessResult("car deleted");
    }

    private Result checkIfCarExists(int carId) {
        if (!this.carDao.existsById(carId)) {
            return new ErrorResult("car not found");
        }
        return new SuccessResult("car found");
    }

/*
    @Override
    public DataResult<List<CarDetail>> getCarsWithBrandAndColorDetails() {
        List<CarDetail> result = this.carDao.getCarWithBrandAndColorDetails();
        return new SuccessDataResult<List<CarDetail>>(result,Messages.CARBRANDANDCOLORLIST);
    }
*/
  /*  @Override
    public DataResult<List<CarDetail>> getCarByBrandId(int brandId) {
        Result resultcheck = BusinessRules.run(checkIfBrandExists(brandId));

        if (resultcheck != null) {
            return new ErrorDataResult<List<CarDetail>>(null,Messages.BRANDNOTFOUND);
        }
        List<Car> result = this.carDao.getByBrand_BrandId(brandId);
        List<CarDetail> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarDetail.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarDetail>>(response,Messages.CARGETBRAND);
    }
*/
  /*  @Override
    public DataResult<List<CarDetail>> getCarByColorId(int colorId) {
        Result resultcheck = BusinessRules.run(checkIfColorExists(colorId));

        if (resultcheck != null) {
            return new ErrorDataResult<List<CarDetail>>(null,Messages.COLORNOTFOUND);
        }
        List<Car> result = this.carDao.getByColor_ColorId(colorId);
        List<CarDetail> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarDetail.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarDetail>>(response,Messages.CARGETCOLOR);
    }
*/
  /*  @Override
    public DataResult<CarSearchListDto> getById(int carId) {

        Result result = BusinessRules.run(checkIfCarExists(carId));
        if (result!=null){
            return new ErrorDataResult(result);
        }

        Car car = this.carDao.findById(carId).get();

            CarSearchListDto carSearchListDto = modelMapperService.forDto().map(car, CarSearchListDto.class);
            return new SuccessDataResult<CarSearchListDto>(carSearchListDto,Messages.CARGET);

    }
*/
  /* @Override
    public DataResult<List<CarDetailDto>> getByCarAllDetail(int carId) {
        Result result = BusinessRules.run(checkIfCarExists(carId));
        if (result != null) {
            return new ErrorDataResult<List<CarDetailDto>>(null,Messages.CARNOTFOUND);
        }

        Car cars = this.carDao.getById(carId);
        List<CarDetailDto> carDetailDtos = new ArrayList<CarDetailDto>();
        CarDetailDto carDetailDto = modelMapperService.forDto().map(cars, CarDetailDto.class);
        carDetailDto.setCarImagesDetail(this.carImageService.getCarImageByCarId(cars.getCarId()).getData());
        carDetailDtos.add(carDetailDto);
        return new SuccessDataResult<List<CarDetailDto>>(carDetailDtos, Messages.CARLIST);
    }
*/
   /* @Override
    public DataResult<List<CarSearchListDto>> getCarByCityId(int cityId) {

        Result resultCheck = BusinessRules.run(checkIfCityExists(cityId));
        if (resultCheck!=null){
            return  new ErrorDataResult(resultCheck);
        }

        List<Car> result = this.carDao.getByCity_CityId(cityId);
        List<CarSearchListDto> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CarSearchListDto>>(response,Messages.CARGETCITY);
    }*/

  /*  @Override
    public Result updateCarCity(int carId, int cityId) {

        Car request = this.carDao.getById(carId);
        request.setCity(this.cityService.getByCity(cityId).getData());
        this.carDao.save(request);
        return new SuccessResult(Messages.CITYUPDATE);
    }
*/
   /* @Override
    public Result updateCarKm(int carId, String kilometer) {
        Car car = this.carDao.getById(carId);
        car.setKilometer(kilometer);
        this.carDao.save(car);
        return new SuccessResult(Messages.CARKMUPDATE);
    }
*/



   /* @Override
    public Result checkIfExistsColorInCar(int colorId) {
        if (!this.carDao.getByColor_ColorId(colorId).isEmpty()) {
            return new SuccessResult(Messages.COLORDELETEERROR);
        }
        return new ErrorResult();
    }
*/
  /*  @Override
    public Result checkIfExistsBrandInCar(int brandId) {
        if (!this.carDao.getByBrand_BrandId(brandId).isEmpty()) {
            return new SuccessResult(Messages.BRANDDELETEERROR);
        }
        return new ErrorResult();
    }*/

   /* private Result checkIfColorExists(int colorId) {
        if (!this.colorService.checkIfColorExists(colorId).isSuccess()) {
            return new ErrorResult(Messages.COLORNOTFOUND);
        }
        return new SuccessResult();
    }*/

   /* private Result checkIfBrandExists(int brandId) {
        if (!this.brandService.checkIfBrandExists(brandId).isSuccess()) {
            return new ErrorResult(Messages.BRANDNOTFOUND);
        }
        return new SuccessResult();
    }
*/
    /*private Result checkIfCarReturnRental(int carId) {
        if (!this.rentalService.checkIfCarIsReturned(carId).isSuccess()) {
            return new ErrorResult(Messages.CARDONOTRETURNFROMRENTAL);
        }
        return new SuccessResult();
    }
*/
  /*  private Result checkIfCarReturnMaintenance(int carId) {
        if (!this.maintenanceService.checkIfCarIsMaintenance(carId).isSuccess()) {
            return new ErrorResult(Messages.CARMAINTENANCEFOUND);
        }
        return new SuccessResult();
    }*/

   /* private Result checkIfCityExists(int cityId){
        if (!this.cityService.getByCity(cityId).isSuccess()){
            return new ErrorResult(Messages.CITYNOTFOUND);
        }
        return new SuccessResult();
    }
*/
}
