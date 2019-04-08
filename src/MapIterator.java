import java.util.Iterator;
import java.util.Map;

public class MapIterator implements Iterator<Map> {
	
	private Map map;
	private Iterator iter;
	
	public MapIterator() {
		map = null;
		iter = null;
	}
	
	public MapIterator(Map map) {
		this.map = map;
		this.iter = map.entrySet().iterator();
	}
	
	@Override
	public boolean hasNext() {
		if (this.iter.hasNext()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map next() {
		// TODO return entry
		return null;
	}

}
