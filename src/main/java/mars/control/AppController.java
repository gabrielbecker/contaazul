package mars.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mars.model.StandartRobot;
import mars.model.Terrain;
import mars.exceptions.IllegalMovementException;
import mars.model.Mars;
import mars.model.Robot;

@Controller
@RestController
@RequestMapping("/rest/mars")
public class AppController {
	
	
	
	/**
	 * Método responsável pelo aspecto stateless do rest. Onde cada nova chamada dela, 
	 * feita através uma nova requisição POST, um novo terreno e um novo robo são criados.
	 * O método irá enviar cada um dos movimentos recebidos para o robo.
	 * 
	 * @param moveSet O conjunto de movimentos a ser aplicado pelo robo.
	 * @return A resposta irá conter ou a posição final do robo ou a mensagem de erro BAD_REQUEST.
	 */
	@RequestMapping(value = "/{moveSet}", method = RequestMethod.POST)
	public ResponseEntity<?> moveRobot(@PathVariable("moveSet") char[] moveSet) {
		
		Terrain terrain = new Mars();
		Robot robot = new StandartRobot(terrain);
				
		String result = new String();
		HttpStatus status = HttpStatus.OK;

		for (char c : moveSet) {
			try {
				result = robot.move(c);
			} catch (IllegalMovementException e) {
				status = HttpStatus.BAD_REQUEST;
				return ResponseEntity.status(status).body(status.value() + " " + status.getReasonPhrase());
			}
		}

		return new ResponseEntity<String>(result, status);			
			
		
	}
	

	
	
}