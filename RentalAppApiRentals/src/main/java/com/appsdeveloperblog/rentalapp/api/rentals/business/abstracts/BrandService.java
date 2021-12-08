package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;


import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequest;

import java.util.List;

public interface BrandService {
	DataResult<List<Brand>> getAll();
	Result add(CreateBrandRequest createBrandRequest);
	Result update(UpdateBrandRequest updateBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
	//Result checkIfBrandExists(int brandId);
}
