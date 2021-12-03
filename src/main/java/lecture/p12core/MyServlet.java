package lecture.p12core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class MyServlet {
	
	@Autowired // 생성자가 하나만 존재할 경우 @Autowired가 없어도 DI 됨.
	private MyDao myDao;

}
