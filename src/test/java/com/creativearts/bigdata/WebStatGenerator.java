package com.creativearts.bigdata;

import com.cloudera.dsi.dataengine.utilities.TimestampTz;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

/**
 * Created by amarendra on 14/04/17.
 */
@Component
public class WebStatGenerator {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger LOG= LoggerFactory.getLogger(WebStatGenerator.class);
    private static DataFactory df = new DataFactory();





        public void generateData (WebStatGenerator webStatGenerator){
            for (int i = 0; i < 10; i++) {
                WebLogs webLog =
                        new WebLogs();
                webLog.setHost(webStatGenerator.selectHost());
                webLog.setDomain(webStatGenerator.selectDomain());
                webLog.setDate(webStatGenerator.selectDate());
                webLog.setFeature(webStatGenerator.selectFeature());
                webLog.setActiveVisitor(df.getNumberUpTo(999));
                webLog.setDb(df.getNumberUpTo(999));
                webLog.setCore(df.getNumberUpTo(999));
                LOG.info("Created WebLogs --> " + webLog);
                String sql = "INSERT INTO WebLogs VALUES (?,?, ?, ?, ?, ?, ?)";

            int update = jdbcTemplate.update(sql, new Object[]{webLog.getHost(),
                    webLog.getDomain(), TimestampTz.from(Instant.now()), webLog.getFeature(),
                    webLog.getActiveVisitor(), webLog.getDb(), webLog.getCore()});

                System.out.println("UPDATE STAT*******************:"+update);
            if (update == -1){
                LOG.info("Inserted WebLogs --> "+ webLog);
            }

            }
        }

        private String selectHost () {
            String[] hosts = {"NA", "EU", "AU", "IN"};
            int idx = new Random().nextInt(hosts.length);
            String random = (hosts[idx]);
            return random;
        }

        private String selectDomain () {
            String[] domains = {"Salesforce.com", "Apple.com", "Google.com", "Facebook.com", "Yahoo.com", "Microsoft.com"};
            int idx = new Random().nextInt(domains.length);
            String random = (domains[idx]);
            return random;
        }

        private String selectFeature () {
            String[] feature = {"Login", "Reports", "Dashboard", "Mac", "Ipad", "Search"};
            int idx = new Random().nextInt(feature.length);
            String random = (feature[idx]);
            return random;
        }

        private java.sql.Date selectDate () {
            Date minDate = df.getDate(2000, 1, 1);
            Date maxDate = new Date();
            java.sql.Date date = new java.sql.Date(df.getDateBetween(minDate, maxDate).getTime());
            return date;
        }

}
