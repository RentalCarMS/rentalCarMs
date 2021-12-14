package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.dtos.UserSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.UserRequest.LoginUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    DataResult<UserSearchListDto> getByEmail(String email);
    Result checkIfEmailExists(String email);
    DataResult<UserSearchListDto> getById(int id);
    Result checkIfUserExists(int userId);

    DataResult<UserSearchListDto> getUserDetailsByEmail(String email);

}
