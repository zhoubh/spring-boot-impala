package com.example;

import com.cloudera.impala.jdbc41.DataSource;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by amarendra on 26/04/17.
 */
public class ImpalaTest {

    public static void main(String[] args) throws IOException {

        System.setProperty("javax.security.auth.useSubjectCredsOnly", "true");
        System.setProperty("java.security.krb5.conf", "D:\\kerberos\\krb5.conf");
        System.setProperty("java.security.auth.login.config","D:\\kerberos\\jaas.conf");
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hadoop.security.authentication", "kerberos");
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab("zhoubh@CREATIVEARTS.CN", "D:\\kerberos\\zhoubh.keytab");


        String url = "jdbc:impala://dev03.creativearts.cn:21050;AuthMech=1;KrbRealm=CREATIVEARTS.CN;" +
                "KrbHostFQDN=dev03.creativearts.cn;KrbServiceName=impala";
        DataSource dataSource = new DataSource();
        dataSource.setURL(url);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();


            statement = connection.createStatement();

            String query = "SELECT id, name FROM default.customers LIMIT 20";

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println("Id: " + resultSet.getInt("id")
                        + " Name: " + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
