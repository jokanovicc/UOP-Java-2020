package model.enumeracije;

public enum MarkaModelDeo {
	FORDFOCUS,
	VOLKSWAGENGOLF,
	TOYOTACOROLLA,
	FIATSTILO,
	OPETASTRA;
	public static MarkaModelDeo valueOf(int a) {
		switch(a) {
		case 1:
			return FORDFOCUS;
		case 2:
			return VOLKSWAGENGOLF;
		case 3:
			return TOYOTACOROLLA;
		case 4:
			return FIATSTILO;
		default:
			return OPETASTRA;
			
		}
	}
	public static int toInt(MarkaModelDeo markaModelDeo) {
		switch(markaModelDeo) {
		case FORDFOCUS:
			return 1;
		case VOLKSWAGENGOLF:
			return 2;
		case TOYOTACOROLLA:
			return 3;
		case FIATSTILO:
			return 4;
		default:
			return 5;
		}
	}
	
	

}
