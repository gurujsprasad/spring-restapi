package gpd.spring_rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class BadRequestExceptions extends RuntimeException{

	public BadRequestExceptions(String message) {
		super (message);
	}
	
	public BadRequestExceptions(String message, Throwable cause) {
		super(message, cause);
	}
}
