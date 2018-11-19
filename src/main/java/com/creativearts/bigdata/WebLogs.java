package com.creativearts.bigdata;

import java.util.Date;

/**
 * @author:zhoubh
 * @create:2018-11-16
 **/

public class WebLogs {
    private String  host;
    private String  domain;
    private Date date;
    private String  feature;
    private int  core;
    private int  activeVisitor;
    private int  db;

    public void setDate(Date date) {
        this.date = date;
    }


    public void setActiveVisitor(int activeVisitor) {
        this.activeVisitor = activeVisitor;
    }



    public void setDb(int db) {
        this.db = db;
    }

    public void setCore(int core) {
        this.core = core;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


    public void setFeature(String feature) {
        this.feature = feature;
    }


    public String getHost() {
        return host;
    }

    public String getDomain() {
        return domain;
    }

    public String getFeature() {
        return feature;
    }


    public int getCore() {
        return core;
    }

    public int getActiveVisitor() {
        return activeVisitor;
    }

    public int getDb() {
        return db;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "WebLogs{" +
                "host='" + host + '\'' +
                ", domain='" + domain + '\'' +
                ", date=" + date +
                ", feature=" + feature +
                ", core=" + core +
                ", activeVisitor=" + activeVisitor +
                ", db=" + db +
                '}';
    }


}
