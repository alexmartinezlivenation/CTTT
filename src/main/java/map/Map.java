package map;

public class Map {
	private String[] mapField;

	public void initializeMap(int size) {
		if (size == 0) {
			mapField = new String[0];
			return;
		}
		mapField = new String[size * 2 - 1];
		
		int baseRowValue;
		
		for (int row=0; row < mapField.length; row++) {
			if (row % 2 == 0) {
				baseRowValue = (row/2)*size;
				mapField[row] = " " + Integer.toString(baseRowValue) + " ";
				
				for (int column=1; column < size; column++) {
					mapField[row] = mapField[row] + "|" + " " + Integer.toString(baseRowValue + column) + " ";
				}
			}
			else {
				mapField[row] = "-";
				for (int column=1; column<mapField[row-1].length(); column++) {
					mapField[row] = mapField[row] + "-";
				}
			}
			
		}
	}
	
	public boolean updateMap(int position, String player) {
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
	}
	
	public String[] getMapField() {
		return mapField;
	}

	public void setMapField(String[] mapField) {
		this.mapField = mapField;
	}
	
	
}
