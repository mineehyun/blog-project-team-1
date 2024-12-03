package doit.blog.controller.user.exceptions;

public class InvalidLoginIdException extends Throwable {
    String errorMessage;
    public InvalidLoginIdException(String s) {
        this.errorMessage = s;
    }

    public String getMessage(){
        return this.errorMessage;
    }
}
