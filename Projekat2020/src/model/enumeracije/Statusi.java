package model.enumeracije;

public enum Statusi {
	SLOBODAN,
	ZAKAZAN;
	
	public static Statusi valueOf(int a) {
		switch(a) {
		case 1:
			return SLOBODAN;
		default:
			return ZAKAZAN;
			
		}
	}
	
	public static int toInt(Statusi statusi) {
		switch(statusi) {
		case SLOBODAN:
			return 1;
		default:
			return 2;
		}
	}

}
