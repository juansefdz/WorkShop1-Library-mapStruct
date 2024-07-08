package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.infraestructure.abstract_services.generic.CreateService.*;
import org.springframework.stereotype.Service;

@Service
public interface ILoanService extends
        CreateService<LoanRequest, LoanResponse>,
        DeleteService<Long>,                                //this is disable status
        ReadAllService<LoanResponse>,
        ReadService<LoanResponse,Long>,
        UpdateService<LoanRequest,LoanResponse, Long> {
}
