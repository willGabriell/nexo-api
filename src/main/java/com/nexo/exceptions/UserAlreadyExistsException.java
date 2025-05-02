package com.nexo.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException() {
        super("Já existe um usuário com esse email cadastrado");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
