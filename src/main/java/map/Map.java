package map;

public class Map {
	private String[] mapField;
	
	public void initializeMap(int size) {
		if (size == 0) {
			mapField = new String[0];
			return;
		}
		
		mapField = new String[size*size];
		for (int populatedValue=0; populatedValue<mapField.length; populatedValue++) {
			mapField[populatedValue] = Integer.toString(populatedValue);
		}
	}
	
	public boolean updateMap(int position, String player) {
		if ((position>=0) && position < mapField.length) {
			if (mapField[position].equals(Integer.toString(position))) {
				mapField[position] = player;
				return true;
			}
		}
		return false;
	}
	
	public String[] getMapField() {
		return mapField;
	}

	public void setMapField(String[] mapField) {
		this.mapField = mapField;
	}
	
	
}
