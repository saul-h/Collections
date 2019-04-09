import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Team {
	public List<String> list;
	public Team(List<String> type) {
		if(type instanceof ArrayList) {
			list = new ArrayList<String>();
		}else {
			list = new LinkedList<String>();
		}
	}
	
	public void load(String item) {
		list.add(item);
		Collections.shuffle(list);
	}
}
