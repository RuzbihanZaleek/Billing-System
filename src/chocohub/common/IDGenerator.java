/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocohub.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

/**
 *
 * @author Ruzbihan
 */
public class IDGenerator {

    public static String getNewID(String tableName, String colName, String prefix) throws ClassNotFoundException, SQLException {
        String sql = "select " + colName + " from " + tableName + " order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (!rs.next()) {
            String lastId = rs.getString(1);
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;

            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }
}
