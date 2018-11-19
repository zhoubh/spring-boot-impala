package com.creativearts.bigdata.service;

import com.creativearts.bigdata.dao.MoxiePhoneNoDao;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zhoubh
 * @create:2018-11-17
 **/
@Service
public class UpdateTagsPhoneNo {
    private static Logger logger = LoggerFactory.getLogger(UpdateTagsPhoneNo.class);
    @Autowired
    private MoxiePhoneNoDao moxiePhoneNoDao;

    public void updateTags(String key, String data){
         if(StringUtils.isNotEmpty(data)){
             moxiePhoneNoDao.UpdateData(data);
         }

    }

}
