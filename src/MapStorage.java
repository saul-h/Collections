import java.util.Map;

public class MapStorage {
	private Map<String, Integer> map;
	
	public MapStorage(Map<String, Integer> map) {
		this.map = map;
	}
	
	public void add(String s, Integer v) {
		map.put(s, v);
	}
	
	public Map<String, Integer> get() {
		return this.map;
	}
}
