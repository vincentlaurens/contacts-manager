package com.fredericboisguerin.insa;

import java.util.regex.* ;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String messageException) {
        super(messageException);
    }


}
