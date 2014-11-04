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
	
	/*public boolean updateMap(int position, String player) {
		int mapLength = mapField.length;
		
		//check if out of bounds
		if((mapLength == 0) || (position >= (mapLength*2 - 1))) {
			return false;
		}

		//set value
		String strPosition = Integer.toString(position);
		int rowSize = (mapField[0].length() + 1)/4;
		int row = (position/rowSize) * 2;  //the multiplier accounts for dashed lines
		
		if (mapField[row].contains(strPosition)) {
			mapField[row] = mapField[row].replace(strPosition, player);
		}
		else {
			return false;
		}
		
		
		return true;
	}*/
	
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
