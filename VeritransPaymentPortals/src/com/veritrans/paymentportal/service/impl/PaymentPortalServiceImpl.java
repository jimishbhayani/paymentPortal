package com.veritrans.paymentportal.service.impl;

import java.util.List;

import com.veritrans.paymentportal.dao.impl.PaymentPortalDAOFactory;
import com.veritrans.paymentportal.model.PaymentService;
import com.veritrans.paymentportal.service.IPaymentPortalService;

public class PaymentPortalServiceImpl implements IPaymentPortalService {

    @Override
    public List<PaymentService> getServicesByName(String name) {
        return PaymentPortalDAOFactory.getPaymentPortalDAO("MySQL").getServicesByName(name);
    }

    @Override
    public List<PaymentService> getServicesByCurrencies(String... currencies) {
        return PaymentPortalDAOFactory.getPaymentPortalDAO("MySQL").getServicesByCurrencies(currencies);
    }

    @Override
    public List<PaymentService> getAllServices() {
        return PaymentPortalDAOFactory.getPaymentPortalDAO("MySQL").getAllServices();
    }

    @Override
    public int getServicesCount() {
        return PaymentPortalDAOFactory.getPaymentPortalDAO("MySQL").getServicesCount();
    }

}
