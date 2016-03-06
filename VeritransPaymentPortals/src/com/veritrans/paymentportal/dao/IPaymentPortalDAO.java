package com.veritrans.paymentportal.dao;

import java.util.List;

import com.veritrans.paymentportal.model.PaymentService;

public interface IPaymentPortalDAO {

    public List<PaymentService> getServicesByName(String name);

    public List<PaymentService> getServicesByCurrencies(String... currencies);

    public List<PaymentService> getAllServices();

    public int getServicesCount();

}
