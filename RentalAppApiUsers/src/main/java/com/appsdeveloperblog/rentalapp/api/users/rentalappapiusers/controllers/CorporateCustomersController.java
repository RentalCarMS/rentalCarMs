package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.controllers;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.abstracts.CorporateCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.CorporateCustomerRequest.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.CorporateCustomerRequest.DeleteCorporateCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.CorporateCustomerRequest.UpdateCorporateCustomerRequest;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.IndıvıdualCustomerRequest.CreateIndividualCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/corporateCustomer")
public class CorporateCustomersController {
    private CorporateCustomerService corporateCustomerService;

    @Autowired
    public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
        super();
        this.corporateCustomerService = corporateCustomerService;
    }



    @GetMapping("getAll")
    public DataResult<List<CorporateCustomerSearchListDto>> getAll() {
        return this.corporateCustomerService.getAll();
    }

    @PostMapping("/add")
    public Result createUser(@RequestBody @Valid CreateCorporateCustomerRequest createCorporateCustomerRequest ) {
        return this.corporateCustomerService.add(createCorporateCustomerRequest);
    }

    @PutMapping("update")
    public Result update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        return this.corporateCustomerService.update(updateCorporateCustomerRequest);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody @Valid DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
        return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
    }
}
