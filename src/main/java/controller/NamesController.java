package controller;

import java.time.Duration;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class NamesController {
	@GetMapping(value="names")
	//Flujo de cadenas de caracteres
	public Flux<String> getNames(){
		//Lista de 4 cadenas de caracteres
		List<String> names=List.of("one", "two", "three", "four");
		//De esta lista queremos generar un flujo y que cada cadena
		//se vaya emitiendo con cierto retardo para ver un caso real
		//de un MS con un Controlador que tarda devolvernos una respuesta
		//o que cada dato de la respuesta que nos tiene que devolver
		//va con una determinada cadencia:
		
		//Se crea el objeto Flux a partir de la lista:
		return Flux.fromIterable(names) //ya acá tenemos un String de Tipo Flux
										//o un Flux de String
				.delayElements(Duration.ofSeconds(2)); //No devuelve el mismo
													  //flujo de String pero
													  //aplicando cierto retardo
													  //entre cada elemento														
	}
}
