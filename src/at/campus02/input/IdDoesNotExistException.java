package at.campus02.input;

public class IdDoesNotExistException extends Exception{
private String message;

public IdDoesNotExistException(String message){
	this.message=message;
}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "IdDoesNotExistException{" +
				"message='" + message + '\'' +
				'}';
	}
}
