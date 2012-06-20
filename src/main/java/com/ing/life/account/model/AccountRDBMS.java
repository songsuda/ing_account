/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.model;

import java.math.BigDecimal;
import java.sql.*;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class AccountRDBMS {

    private static Logger logger = Logger.getLogger(AccountRDBMS.class);
    Connection conn = null;

    public AccountRDBMS() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://192.168.3.1:9101/Users/roofimon/Development/h2/database/test_ing", "sa", "");
        } catch (Exception error) {
            logger.error("An Exception: " + error.toString());
        }
    }

    public void getAllAccount() throws SQLException {

        Statement stmt = null;
        String query = "select code, name, balance from account";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                BigDecimal price = rs.getBigDecimal("balance");
                logger.debug(code + "\t" + name
                        + "\t" + price + "\t");
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
