package com.veritrans.paymentportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.veritrans.paymentportal.dao.IPaymentPortalDAO;
import com.veritrans.paymentportal.model.PaymentService;

public class PaymentPortalDAOMySQLImpl implements IPaymentPortalDAO {

    Connection conn = null;

    @Override
    public List<PaymentService> getServicesByName(String name) {
        Connection conn = getConnection();
        Statement stmt;
        List<PaymentService> serviceList = new ArrayList<PaymentService>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM VT_Services where name like '%" + name + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PaymentService staff = populateServiceObject(rs);
                serviceList.add(staff);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public List<PaymentService> getServicesByCurrencies(String... currencies) {
        Connection conn = getConnection();
        Statement stmt;
        List<PaymentService> serviceList = new ArrayList<PaymentService>();
        try {
            StringBuilder sb = new StringBuilder("SELECT * FROM VT_Services where currencies like '%");
            sb.append(currencies[0]);
            sb.append("%'");

            for (int i = 1; i < currencies.length; i++) {
                sb.append(" OR ");
                sb.append("currencies like '%");
                sb.append(currencies[i]);
                sb.append("%'");
            }
            stmt = conn.createStatement();
            String sql = sb.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PaymentService staff = populateServiceObject(rs);
                serviceList.add(staff);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public List<PaymentService> getAllServices() {
        Connection conn = getConnection();
        Statement stmt;
        List<PaymentService> serviceList = new ArrayList<PaymentService>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM VT_Services";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PaymentService staff = populateServiceObject(rs);
                serviceList.add(staff);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public int getServicesCount() {
        Connection conn = getConnection();
        Statement stmt;
        int count = 0;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT count(id) FROM VT_Services";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 
     * Populates the PaymentService Object From Result Set.
     * This is common code for multiple methods, so created a Private Method for this.  
     * 
     * @param rs
     * @return PaymentService
     * @throws SQLException
     */
    private PaymentService populateServiceObject(ResultSet rs) throws SQLException {
        PaymentService ps = new PaymentService();
        ps.setId(rs.getInt("id"));
        ps.setName(rs.getString("name"));
        ps.setImage(rs.getString("image"));
        ps.setDescription(rs.getString("description"));
        ps.setBranding(rs.getBoolean("branding"));
        ps.setRating(rs.getDouble("rating"));
        ps.setSetupFee(rs.getDouble("setup_fee"));
        ps.setTransactionFee(rs.getString("transaction_fees"));
        ps.setCurrencies(rs.getString("currencies"));
        ps.setHowToUrl(rs.getString("how_to_url"));
        return ps;
    }

    /**
     * 
     * This method give the SLQConnection to the Database 
     * based on the Connection info Provided.
     * 
     * @return Connection
     */
    private Connection getConnection() {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/test";
        final String USER = "root";
        final String PASS = "";
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
