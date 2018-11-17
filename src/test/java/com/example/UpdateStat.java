package com.example;

import com.cloudera.dsi.dataengine.utilities.TimestampTz;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author:zhoubh
 * @create:2018-11-17
 **/
@Component
public class UpdateStat {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  static  final Logger LOG = LoggerFactory.getLogger(UpdateStat.class);
    //private static DataFactory df = new DataFactory();

    public  void UpdateData(String phoneNo){
        String sql = "insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key`= ?";

        int update = jdbcTemplate.update(sql, new Object[]{phoneNo});

        System.out.println("UPDATE STAT*******************:"+update);

        if (update == -1){
            LOG.info("UpdateData  --> "+ phoneNo);
        }

    }
}
