package mars.model;

import mars.exceptions.IllegalMovementException;

/**
 * Contém as funções basicas que um robo deve implementar.
 * 
 * @author gabriel
 *
 */
public interface Robot {
	
	/**
	 * Um robo sempre estará virado para uma das posições representadas por este Enum, Norte, Sul, Leste ou Oeste.
	 * 
	 * @author gabriel
	 *
	 */
	enum Face {
		N, 
		E,
		S,
		W;		
	};

	
	/**
	 * 
	 * Realiza um movimento do robo.
	 * 
	 * @param c O movimento que o robo deverá realizar.
	 * @return A posição do robo após a execução do movimento
	 * 
	 * @throws IllegalArgumentException Caso seja um movimento incorreto ou se o movimento provocar a ida 
	 * do robo para fora da área do terreno.
	 */
	public String move(char c) throws IllegalMovementException;
	
	
	/**
	 * 
	 * Retorna a posição atual do robo.
	 * 
	 * @return A posição atual do robo.
	 */
	public String getPosition(); 

}
