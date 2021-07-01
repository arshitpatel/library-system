package com.library.lending.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class ControllerExceptionHandler extends DefaultHandlerExceptionResolver {

	@ExceptionHandler(OperationNotAllowed.class)
	public ResponseEntity<APIResponse> handleValidationError(OperationNotAllowed ex, HttpServletRequest req) {
		APIResponse response = new APIResponse();
		response.setMessage(ex.getMessage());
		response.setStatus("Failed");
		return buildResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<APIResponse> handleValidationError(Exception ex, HttpServletRequest req) {
		APIResponse response = new APIResponse();
		response.setMessage("Request Failed due to Internal Server Error.");
		response.setStatus("Failed");
		return buildResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private <T> ResponseEntity<T> buildResponseEntity(T body, HttpStatus status) {
		return new ResponseEntity<T>(body, status);
	}
}

class APIResponse {
	private String message;
	private String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}