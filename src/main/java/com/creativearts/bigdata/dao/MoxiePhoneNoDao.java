package com.creativearts.bigdata.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author:zhoubh
 * @create:2018-11-17
 **/
@Service
public class MoxiePhoneNoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private  static  final Logger LOG = LoggerFactory.getLogger(MoxiePhoneNoDao.class);

    public  void UpdateData(String phoneNo){

        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String sql = "insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key`= ?";
                int update = jdbcTemplate.update(sql, new Object[]{phoneNo});
                if (update == -1){
                    LOG.info("UpdateData1  --> "+ phoneNo);
                }
                String sql2 = "insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key` > ?";
                int update2 = jdbcTemplate.update(sql2, new Object[]{phoneNo});
                if (update2 == -1){
                    LOG.info("UpdateData2  --> "+ phoneNo);
                }
            }
        });
    }

}
