package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.BrandService;
//import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.CarService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.bussines.BusinessRules;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.*;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.BrandDao;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequest;
//import com.etiya.RentACar.business.abstracts.BrandService;
//import com.etiya.RentACar.business.abstracts.CarService;
//import com.etiya.RentACar.business.constants.Messages;
//import com.etiya.RentACar.business.requests.brand.CreateBrandRequest;
//import com.etiya.RentACar.business.requests.brand.DeleteBrandRequest;
//import com.etiya.RentACar.business.requests.brand.UpdateBrandRequest;
//import com.etiya.RentACar.core.utilities.business.BusinessRules;
//import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
//import com.etiya.RentACar.core.utilities.results.*;
//import com.etiya.RentACar.dataAccess.abstracts.BrandDao;
//import com.etiya.RentACar.entites.Brand;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private BrandDao brandDao;
    private ModelMapperService modelMapperService;
    @Autowired
    private BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
        super();
        this.brandDao = brandDao;
        this.modelMapperService = modelMapperService;

    }

    @Override
    public DataResult<List<Brand>> getAll() {
        return new SuccessDataResult<List<Brand>>(this.brandDao.findAll(),"brandler listelendi");
    }

    @Override
    public Result add(CreateBrandRequest createBrandRequest) {
        Result result = BusinessRules.run(this.checkIfBrandNameExists(createBrandRequest.getBrandName()));
        if (result != null) {
            return result;
        }

        Brand brand2 = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandDao.save(brand2);
        return new SuccessResult("brand added");
    }

    @Override
    public Result update(UpdateBrandRequest updateBrandRequest) {
        Result result = BusinessRules.run(checkIfBrandNameExists(updateBrandRequest.getBrandName()));
        if (result != null) {
            return result;
        }

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandDao.save(brand);
        return new SuccessResult("brand Updated");
    }

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
        this.brandDao.delete(brand);
        return new SuccessResult("brand delete");
    }
/*
    @Override
    public Result checkIfBrandExists(int brandId) {
        if (!this.brandDao.existsById(brandId)) {
            return new ErrorResult(Messages.BRANDNOTFOUND);
        }
        return new SuccessResult(Messages.BRANDGET);
    }
*/
    /*
    private Result checkIfIsThereCarOfThisBrand(int brandId) {
        if (this.carService.checkIfExistsBrandInCar(brandId).isSuccess()) {
            return new ErrorResult(Messages.BRANDDELETEERROR);
        }
        return new SuccessResult();
    }*/

    private Result checkIfBrandNameExists(String brandName) {
        if (this.brandDao.existsByBrandName(brandName)) {
            return new ErrorResult("brand name is already added");
        }
        return new SuccessResult();
    }

}
