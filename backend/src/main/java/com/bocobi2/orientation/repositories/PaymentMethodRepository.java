package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.PaymentMethod;

public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {

    public PaymentMethod findBypaymentMethodId(String paymentMethodId);
    public List<PaymentMethod> findBypaymentMethodName(String paymentMethodName);

}