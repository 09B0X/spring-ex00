package lecture.p10coreExercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		String config = "lecture/p10coreExercise/context.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		System.out.println(context.getBean("computer")); // not null, not exception
		System.out.println(context.getBean("memory")); // not null, not exception

		System.out.println(context.getBean(Computer.class).getMemory()); // not null, not exception
	}
}
