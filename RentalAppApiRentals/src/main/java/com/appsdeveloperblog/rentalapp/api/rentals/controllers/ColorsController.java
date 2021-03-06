package com.appsdeveloperblog.rentalapp.api.rentals.controllers;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.ColorService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequest;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	private ColorService colorService;

	@Autowired
	private ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	@GetMapping("check")
	public String check() {
		return "Work on ";
	}
	@GetMapping("getAll")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.add(createColorRequest);

	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}

}
