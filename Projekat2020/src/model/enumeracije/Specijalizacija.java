package model.enumeracije;

public enum Specijalizacija {
	AUTOMEHANICAR,
	AUTOELEKTRICAR,
	VULKANIZER,
	LIMAR;
	
	public static Specijalizacija valueOf(int a) {
		switch(a) {
		case 1:
			return AUTOMEHANICAR;
		case 2:
			return AUTOELEKTRICAR;
		case 3:
			return VULKANIZER;
		default:
			return LIMAR;
			
		}
	}
	public static int toInt(Specijalizacija specijalizacija) {
		switch(specijalizacija) {
		case AUTOMEHANICAR:
			return 1;
		case AUTOELEKTRICAR:
			return 2;
		case VULKANIZER:
			return 3;
		default:
			return 4;
		}
	}

}