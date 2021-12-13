package org.zup.paulo.comicsmanager.services.interfaces;

import org.zup.paulo.comicsmanager.domain.Exemplary;

import java.util.List;

public interface ExemplaryServiceAPI {

    public Exemplary get(Long id);

    public List<Exemplary> findAll();

    public Exemplary create(Exemplary exemplary);

    public void update(Exemplary exemplary);

    public void remove(Long id);
}
