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
