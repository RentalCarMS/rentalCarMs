package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.ColorService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.bussines.BusinessRules;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.*;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.ColorDao;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorManager implements ColorService {

    private ColorDao colorDao;
    private ModelMapperService modelMapperService;

    @Autowired
    private ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
        super();
        this.colorDao = colorDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<Color>> getAll() {
        return new SuccessDataResult<>(this.colorDao.findAll(),"colorlar listelendi");
    }

    @Override
    public Result add(CreateColorRequest createColorRequest) {
        Result result = BusinessRules.run(checkIfColorNameExists(createColorRequest.getColorName()));
        if (result != null) {
            return result;
        }

        Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
        this.colorDao.save(color);
        return new SuccessResult("color added");
    }

    @Override
    public Result update(UpdateColorRequest updateColorRequest) {
        Result result = BusinessRules.run(checkIfColorNameExists(updateColorRequest.getColorName()));
        if (result != null) {
            return result;
        }

        Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
        this.colorDao.save(color);
        return new SuccessResult("color update");
    }

    @Override
    public Result delete(DeleteColorRequest deleteColorRequest) {
        Color color = this.modelMapperService.forRequest().map(deleteColorRequest, Color.class);
        this.colorDao.delete(color);
        return new SuccessResult("color delete");
    }
/*
    private Result checkIfExistsColorInCar(int colorId) {
        if (this.carService.checkIfExistsColorInCar(colorId).isSuccess()) {
            return new ErrorResult(Messages.COLORDELETEERROR);
        }
        return new SuccessResult();
    }*/

 /*   @Override
    public Result checkIfColorExists(int colorId) {
        if (!this.colorDao.existsById(colorId)) {
            return new ErrorResult("");
        }
        return new SuccessResult();
    }*/

    private Result checkIfColorNameExists(String colorName) {
        if (this.colorDao.existsByColorName(colorName)) {
            return new ErrorResult("color name zaten var");
        }
        return new SuccessResult();
    }

}
