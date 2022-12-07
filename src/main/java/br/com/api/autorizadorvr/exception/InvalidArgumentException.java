package br.com.api.autorizadorvr.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidArgumentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidArgumentException() {
		super("Já existe um cartão cadastro com esse numero");
	}
	

	public InvalidArgumentException(String message) {
		super(message);
	}

	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}


	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

}

