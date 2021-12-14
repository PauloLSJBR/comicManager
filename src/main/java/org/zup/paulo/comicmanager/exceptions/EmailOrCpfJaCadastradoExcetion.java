package org.zup.paulo.comicmanager.exceptions;

public class EmailOrCpfJaCadastradoExcetion extends RuntimeException {

    public EmailOrCpfJaCadastradoExcetion(String mensagem) {
        super(mensagem);
    }

    public EmailOrCpfJaCadastradoExcetion(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}