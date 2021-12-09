package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.project1.BoardVO;
import org.zerock.mapper.project1.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	public BoardMapper mapper;
	
	@Test
	public void mapperTest() {
		assertNotNull(mapper);
	}
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test 용 제목");
		vo.setContent("test 용 본문");
		vo.setWriter("tester");
		
		int cnt = mapper.insert(vo);
		
		assertEquals(1, cnt);
	}
}
