package mars.model;

/**
 * Uma classe genérica de Terrono.
 * Cada terreno terá no minimo dimensões.
 * 
 * @author gabriel
 *
 */
public abstract class Terrain {

	private int worldMaxHeight;
	private int worldMinHeight;
	
	private int worldMaxWidht;
	private int worldMinWidht;
	
	/**
	 * Cria um terreno genérico com as dadas dimensões.
	 *
	 * @param worldMaxHeight Valor máximo da altura.
	 * @param worldMinHeight Valor mínimo da altura.
	 * @param worldMaxWidht Valor máximo da largura.
	 * @param worldMinWidht Valor mínimo da largura. 
	 */
	public Terrain(int worldMaxHeight, int worldMinHeight, int worldMaxWidht, int worldMinWidht) {
		this.worldMaxHeight = worldMaxHeight;
		this.worldMinHeight = worldMinHeight;
		this.worldMaxWidht = worldMaxWidht;
		this.worldMinWidht = worldMinWidht;
	}
	
	/**
	 * Retorna o valor da altura máxima do terreno.
	 * 
	 * @return int
	 */
	public int getWorldMaxHeight() {
		return worldMaxHeight;
	}
	
	/**
	 * Retorna o valor da altura mínima do terreno.
	 * 
	 * @return int
	 */
	public int getWorldMinHeight() {
		return worldMinHeight;
	}
	/**
	 * Retorna o valor da largura máxima do terreno.
	 * 
	 * @return int
	 */
	public int getWorldMaxWidht() {
		return worldMaxWidht;
	}
	
	/**
	 * Retorna o valor da largura mínima do terreno. 
	 * 
	 * @return int
	 */
	public int getWorldMinWidht() {
		return worldMinWidht;
	}
	
	
}
