package org.zup.paulo.comicmanager.representations;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.zup.paulo.comicmanager.domain.annotation.Cpf;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UserRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotBlank(message = "E-mail é obrigatorio")
    @Email(message = "E-mail invalido")
    private String email;

    @NotBlank(message = "CPF é obrigatorio")
    @Cpf(message = "CPF Invalido")
    private String cpf;

    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    @NotNull(message = "Data de nascimento é obrigatoria")
    private Date dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

}

