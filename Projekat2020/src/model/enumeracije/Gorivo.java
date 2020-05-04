package model.enumeracije;

public enum Gorivo {
	BENZIN,
	DIZEL,
	GAS;
	public static Gorivo valueOf(int a) {
		switch(a) {
		case 1:
			return BENZIN;
		case 2:
			return DIZEL;
		default:
			return GAS;
			
		}
	}
	public static int toInt(Gorivo gorivo) {
		switch(gorivo) {
		case BENZIN:
			return 1;
		case DIZEL:
			return 2;		
		default:
			return 3;
		}
	}

	
	
	
	
	
}

