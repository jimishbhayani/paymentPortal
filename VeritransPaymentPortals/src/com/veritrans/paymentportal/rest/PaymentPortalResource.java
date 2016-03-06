package com.veritrans.paymentportal.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.veritrans.paymentportal.model.PaymentService;
import com.veritrans.paymentportal.service.IPaymentPortalService;
import com.veritrans.paymentportal.service.impl.PaymentPortalServiceImpl;

@Path("/")
public class PaymentPortalResource {

    /**
     * 
     */
    public PaymentPortalResource() {
        super();
    }

    @GET
    @Path("/list")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<PaymentService> getAllPaymentServices() {
        IPaymentPortalService paymentPortalService = new PaymentPortalServiceImpl();
        return paymentPortalService.getAllServices();
    }

    @GET
    @Path("/search")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<PaymentService> getPaymentServicesByName(@QueryParam("query") String name) {
        IPaymentPortalService paymentPortalService = new PaymentPortalServiceImpl();
        return paymentPortalService.getServicesByName(name);
    }

    @GET
    @Path("/search/currency")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<PaymentService> getPaymentServicesByCurrencies(@QueryParam("c") List<String> currency) {
        IPaymentPortalService paymentPortalService = new PaymentPortalServiceImpl();
        String[] currencies = new String[currency.size()];
        return paymentPortalService.getServicesByCurrencies(currency.toArray(currencies));
    }

    @GET
    @Path("/count")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getPaymentServicesCount() {
        IPaymentPortalService paymentPortalService = new PaymentPortalServiceImpl();
        return "{count : "+ paymentPortalService.getServicesCount() +"}";
    }
}
