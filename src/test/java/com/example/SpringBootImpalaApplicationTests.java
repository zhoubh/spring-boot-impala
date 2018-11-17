package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootImpalaApplicationTests {

	@Autowired
	WebStatGenerator webStatGenerator;
	@Autowired
	UpdateStat updateStat;

	@Test
	public void contextLoads() {

	}

	//@Test
	//public void loadData(){
//		webStatGenerator.generateData(webStatGenerator);
//	}

	@Test
	public void updateData(){
		updateStat.UpdateData("123456");
	}
}
