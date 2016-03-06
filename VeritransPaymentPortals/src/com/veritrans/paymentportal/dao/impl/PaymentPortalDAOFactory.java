package com.veritrans.paymentportal.dao.impl;

import com.veritrans.paymentportal.dao.IPaymentPortalDAO;

public class PaymentPortalDAOFactory {

    private static PaymentPortalDAOMySQLImpl daoMySQLImpl;

    public static IPaymentPortalDAO getPaymentPortalDAO(String dataSource) {
        if ("MySQL".equals(dataSource)) {
            return getDaoMySQLImpl();
        }
        return null;
    }

    /**
     * @return the daoMySQLImpl
     */
    public static PaymentPortalDAOMySQLImpl getDaoMySQLImpl() {
        if (daoMySQLImpl == null) {
            daoMySQLImpl = new PaymentPortalDAOMySQLImpl();
        }
        return daoMySQLImpl;
    }

}
