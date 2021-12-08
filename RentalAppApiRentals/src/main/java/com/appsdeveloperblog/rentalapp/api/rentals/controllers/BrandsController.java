package com.appsdeveloperblog.rentalapp.api.rentals.controllers;


import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.BrandService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	private BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("getAll")
	public DataResult<List<Brand>> getAll() {
		return brandService.getAll();
	}

	@GetMapping("check")
	public String check() {
		return "Work on ";
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		return this.brandService.delete(deleteBrandRequest);
	}

}
