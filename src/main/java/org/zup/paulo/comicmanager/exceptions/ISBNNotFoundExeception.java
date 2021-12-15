package org.zup.paulo.comicmanager.exceptions;

public class ISBNNotFoundExeception extends RuntimeException {

    public ISBNNotFoundExeception(String mensagem) {
        super(mensagem);
    }

    public ISBNNotFoundExeception(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
