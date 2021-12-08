package com.appsdeveloperblog.rentalapp.api.rentals.dataAccess;

import com.appsdeveloperblog.rentalapp.api.rentals.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDao extends JpaRepository<Car, Integer> {

	//Car getById(int carId);

	boolean existsById(int carId);

	//List<Car> getByColor_ColorId(int colorId);
	//List<Car> getByBrand_BrandId(int brandId);
	//List<Car> getByCity_CityId(int cityId);
/*
	@Query("Select new com.etiya.RentACar.entites.ComplexTypes.CarDetail"
			+ "(c.carId,b.brandName,cl.colorName,c.modelYear,c.dailyPrice,c.description) "
			+ "From Car c Inner Join c.brand b Inner Join c.color cl")
	List<CarDetail> getCarWithBrandAndColorDetails();
*/
/*	@Query("Select new com.etiya.RentACar.business.dtos.CarSearchListDto"
			+ "(c.carId,c.modelYear,c.dailyPrice,c.description,c.minFindeksScore,c.city.cityName) "
			+ "From Car c Left Join  c.maintenances cm WHERE " +
			"(cm.maintenanceDate is not null AND cm.returnDate is not null) or (cm.maintenanceDate is null AND cm.returnDate is null)")
	List<CarSearchListDto> getAllWithoutMaintenanceOfCar();
*/
}
