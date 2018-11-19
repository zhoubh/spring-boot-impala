# spring-boot-impala

impala sql:

create table customers(id int , name string );
SELECT * from customers ;
create table WebLogs( host string, domain string , `date` string, feature string , core int, activeVisitor int , db int) ;
SELECT *from WebLogs limit 100 ;
drop  table WebLog;
create table WebLog( city string, os_family string ,latitude float ,longitude float) ;
INSERT into WebLog VALUES('New York','NJU',1544.12,6564.21);
INSERT into WebLog VALUES('Shang Hai','UIY',524.1,478.3);
INSERT into WebLog VALUES('Gan Zhou','CDE',125.1,841.6);
SELECT * from WebLog limit 10 ;
SELECT * from WebLog  limit 10 ;


create table t_job_list(id int , sql_text string ,is_in_use int, create_time timestamp, update_time timestamp , update_by string,remark string) stored as parquet ; 

SELECT now();

insert into t_job_list values (1,'insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key`= ?',1,now(),now(),'zhoubh',null);
insert into t_job_list values (2,'insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key` >= ?',1,now(),now(),'lijun',null);
insert into t_job_list values (3,'insert into default.hbase_zykj_test_tag  select  * from default.hbase_zykj_test_original where `key` > ?',1,now(),now(),'qiugq',null);

SELECT * from t_job_list ; 
-- hbase external table 
-- rowkey  reverse(phone)_最大时间(2524579200L)-current_time  remark:topic_offset_ partition  topic:zykj-moxie_phoneNo_offset:570_partition:0
create external  table t_schedule_job_log( `key`  string , job_list_id int ,   phoneno string , start_time string   ,  end_time string ,   duration_ms  bigint  ,remark string)  ;


-- create hbase table 
-- create hive external table 
