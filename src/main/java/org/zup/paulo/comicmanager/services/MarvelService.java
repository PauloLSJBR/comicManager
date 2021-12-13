package org.zup.paulo.comicsmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zup.paulo.comicsmanager.domain.Comic;
import org.zup.paulo.comicsmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicsmanager.representations.response.ComicsResponse;
import org.zup.paulo.comicsmanager.representations.response.ResultsResponse;
import org.zup.paulo.comicsmanager.restclient.MarvelComicsClient;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class MarvelService {
    private static final String PUBLIC_KEY = "720bdf9852d83661fe5e5d57d9aba9ed";
    private static final String PRIVATE_KEY = "144fcb44515c6b5dc3ba4bc959612a90c4895215";

    @Autowired
    private MarvelComicsClient client;

    public Comic findComic(Long comicId) {
        Long timeStamp = new Date().getTime();

        try{
            ComicsResponse response = client.getComic(comicId, timeStamp, PUBLIC_KEY, buildHash(timeStamp));

            ResultsResponse result = response.getData().getResults().get(0);
            Comic comic = new Comic();
            comic.setComicId(result.getId());
            comic.setTítulo(result.getTitle());
            comic.setAutores(result.getCreators().getItems().get(0).getName());
            comic.setPreco(BigDecimal.valueOf(result.getPrices().get(0).getPrice()));
            comic.setDescricao(result.getDescription());
            comic.setIsbn(result.getIsbn());

            return comic;
        } catch (Exception ex) {
            throw new ComicNotFoundException(String.format("Comic não existe na APIMarvel com esse id: %s ", comicId));
        }

    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }


}
