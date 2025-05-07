package com.letho.myproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes =com.letho.myproject.MyprojectApplication.class)
@ActiveProfiles("test")
class MyprojectApplicationTests {

	@Test
	void contextLoads() {
	}

}
