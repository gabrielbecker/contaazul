package mars.model;

public class Mars extends Terrain {

	private final static int worldMaxHeight = 4;
	private final static int worldMinHeight = 0;
	
	private final static int worldMaxWidht = 4;
	private final static int worldMinWidht = 0;
	
	/**
	 * Cria o terreno Marte, de tamanho 5x5.
	 */
	public Mars() {
		super(worldMaxHeight, worldMinHeight, worldMaxWidht, worldMinWidht);
	}
	
}
