package org.zup.paulo.comicsmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicsmanager.domain.Exemplary;
import org.zup.paulo.comicsmanager.domain.User;
import org.zup.paulo.comicsmanager.domain.builders.UserBuilder;
import org.zup.paulo.comicsmanager.exceptions.UserNotFoundException;
import org.zup.paulo.comicsmanager.repositories.interfacesJPA.ExemplaryRepositoryJPA;
import org.zup.paulo.comicsmanager.repositories.interfacesJPA.UserRepositoryJPA;
import org.zup.paulo.comicsmanager.representations.ComicResult;
import org.zup.paulo.comicsmanager.services.interfaces.UserServiceAPI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserService implements UserServiceAPI {

    @Autowired
    private UserRepositoryJPA repositoryJPA;

    @Autowired
    private ExemplaryRepositoryJPA exemplaryReoository;

    @Transactional(readOnly = true)
    public User get(Long id){

        try {
            User user = repositoryJPA.findById(id).get();
            return user;
        } catch (Exception ex) {
            throw new UserNotFoundException(String.format("Banda não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public User create(User user) {

        return repositoryJPA.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(User user) {
        repositoryJPA.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

    @Transactional()
    public List<ComicResult> findComics(Long userId) {

        List<Exemplary> exemplaries = exemplaryReoository.findByUser(new UserBuilder().id(userId).build());

        List<ComicResult> comicResults = new ArrayList<ComicResult>();
        for(Exemplary exemplary: exemplaries) {
            ComicResult comicResult = new ComicResult(exemplary.getComic());
            if(ifDescont(comicResult.getIsbn())) {
                comicResult.setPreco(comicResult.getPreco().multiply(BigDecimal.valueOf(0.9)));
                comicResult.setDescontoApl(true);
            }
            comicResults.add(comicResult);
        }

        return comicResults;
    }

    private Boolean ifDescont(String isbn){

        char ultch = isbn.charAt(isbn.length()-1);
        LocalDate todaysDate = LocalDate.now();

        switch (todaysDate.getDayOfWeek()) {
            case MONDAY:{
                return (ultch == '0' || ultch == '1');
            }
            case TUESDAY:{
                return (ultch == '2' || ultch == '3');
            }
            case WEDNESDAY:{
                return (ultch == '4' || ultch == '5');
            }
            case THURSDAY:{
                return (ultch == '6' || ultch == '7');
            }
            case FRIDAY:{
                return (ultch == '8' || ultch == '9');
            }
            default :
                return false;
        }
    }
}

