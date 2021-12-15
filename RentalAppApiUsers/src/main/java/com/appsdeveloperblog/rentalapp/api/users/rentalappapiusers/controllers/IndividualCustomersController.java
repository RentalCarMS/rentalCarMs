package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.controllers;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.abstracts.IndividualCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.CorporateCustomerRequest.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.IndıvıdualCustomerRequest.CreateIndividualCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.IndıvıdualCustomerRequest.DeleteIndividualCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.IndıvıdualCustomerRequest.UpdateIndividualCustomerRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/individualcustomer")
public class IndividualCustomersController {
    private IndividualCustomerService individualCustomerService;

    @Autowired
    private IndividualCustomersController(IndividualCustomerService individualCustomerService) {
        super();
        this.individualCustomerService = individualCustomerService;
    }

    @GetMapping("check")
    public Result check(){
        return new SuccessResult("On");
    }

    @PostMapping("add")
    public Result createUser(@RequestBody @Valid CreateIndividualCustomerRequest createIndividualCustomerRequest ) {
        return this.individualCustomerService.add(createIndividualCustomerRequest);
    }

    @GetMapping("getAll")
    public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
        return this.individualCustomerService.getAll();
    }

    @PutMapping("update")
    public Result update(@RequestBody @Valid UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return this.individualCustomerService.update(updateIndividualCustomerRequest);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
        return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
    }
}
