package mars.model;

import mars.exceptions.IllegalMovementException;

/**
 * Um robo genérico com movimentação simples.
 * 
 * @author gabriel
 *
 */
public class StandartRobot implements Robot{

	
	private static Face[] faces = Face.values(); //Permite retornar um elemento por seu indice.
			
	private int x; //LESTE-OESTE
	private int y; //NORTE-SUL
	
	private Face face;	
	private Terrain terrain;
	
	/**
	 * Cria um robo no canto inferior esquerdo do terreno, virado ao norte.
	 * 
	 * @param terrain O terreno onde o robo irá andar.
	 */
	public StandartRobot(Terrain terrain) {
		this.x = 0;
		this.y = 0;
		
		this.face = Face.N;
		this.terrain = terrain;
	}
	
	@Override
	public String move(char c) throws IllegalMovementException {
		
		switch (c) {
		case 'L':
			this.face = getFace(Math.floorMod(this.face.ordinal()-1, 4));			
			break;
			
		case 'R':
			this.face = getFace(Math.floorMod(this.face.ordinal()+1, 4));
			break;
			
		case 'M':
			
			if(this.face.ordinal() % 2 == 0){ //Trabalha no eixo Y
				
				if(this.face.equals(Face.N)) {
					goNorth();
				} else {
					goSouth();
				}
				
			} else { //Trabalha no eixo X
				if(this.face.equals(Face.E)) {
					goEast();
				} else {
					goWest();
				}
			}
			
			break;

		default:
			throw new IllegalMovementException("Comando não reconhecido.");
		}
		
		return getPosition();
	}

	@Override
	public String getPosition() {
		return "("+this.x+","+this.y+","+this.face.toString()+")";
	}
	

	private void goNorth() throws IllegalMovementException {
		if(y < terrain.getWorldMaxHeight()) {
			this.y++;
		} else {
			throw new IllegalMovementException("Limite superior");
		}
	}
	
	private void goSouth() throws IllegalMovementException {
		if(y > terrain.getWorldMinHeight()) {
			this.y--;
		} else {
			throw new IllegalMovementException("Limite inferior");
		}
		
	}
	
	private void goEast() throws IllegalMovementException {
		if(x < terrain.getWorldMaxWidht()) {
			this.x++;
		} else {
			throw new IllegalMovementException("Limite a direita");
		}
	}
	
	private void goWest() throws IllegalMovementException {
		if(x > terrain.getWorldMinWidht()) {
			this.x--;
		} else {
			throw new IllegalMovementException("Limite a esquerda");
		}
	}
	
	private static Face getFace(int i) {
		return faces[i];
	}
	
	
}
