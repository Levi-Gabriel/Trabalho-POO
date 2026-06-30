package world;

public enum Direction {
	LESTE, OESTE;
	// depois implemento para poder se mover norte, sul, leste e oeste.
    public static Direction direction(String text) {
        switch (text.trim().toLowerCase()) {
            case "leste": case "l": return LESTE;
            case "oeste": case "o": return OESTE;
            default: return null;
        }
    }
}