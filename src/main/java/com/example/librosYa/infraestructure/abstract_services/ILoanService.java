package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import org.springframework.stereotype.Service;

@Service
public interface ILoanService extends CRUDService <LoanRequest, LoanResponse,Long>{
}
