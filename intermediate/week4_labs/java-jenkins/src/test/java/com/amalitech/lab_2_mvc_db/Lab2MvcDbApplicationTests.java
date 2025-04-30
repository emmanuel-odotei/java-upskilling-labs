package Week;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab2MvcDbApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void testSample(){
		var result = 2 + 2;
		assertEquals (result, 4);
	}
}
