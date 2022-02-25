package com.jiang.websocket;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = WebsocketApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class WebsocketApplicationTests {

	public static void main(String[] args) {
		System.out.println(WebsocketApplicationTests.class.getClassLoader().getResource("/"));
	}
//	@Test
//	public void a(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("License.xml");
//		System.out.println(ctx.getApplicationName());
//	}
}
