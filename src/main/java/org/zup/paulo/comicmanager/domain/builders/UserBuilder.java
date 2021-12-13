package org.zup.paulo.comicmanager.domain.builders;

import org.zup.paulo.comicmanager.domain.User;

import java.util.Date;

public class UserBuilder {

    private User user = new User();

    public UserBuilder id(Long id){
        user.setId(id);
        return this;
    }

    public UserBuilder nome(String nome){
        user.setNome(nome);
        return this;
    }

    public UserBuilder email(String email){
        user.setEmail(email);
        return this;
    }

    public UserBuilder cpf(String cpf){
        user.setCpf(cpf);
        return this;
    }

    public UserBuilder dataNasc(Date dataNasc){
        user.setDataNasc(dataNasc);
        return this;
    }

    public User build(){
        return user;
    }

}
