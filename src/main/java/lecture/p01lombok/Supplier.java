package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supplier {
	private int id;
	private String name;
}
