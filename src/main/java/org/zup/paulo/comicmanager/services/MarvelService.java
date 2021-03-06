package org.zup.paulo.comicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicmanager.exceptions.ISBNNotFoundExeception;
import org.zup.paulo.comicmanager.restclient.response.ComicsResponse;
import org.zup.paulo.comicmanager.restclient.response.CreatorSummary;
import org.zup.paulo.comicmanager.restclient.response.ResultsResponse;
import org.zup.paulo.comicmanager.restclient.MarvelComicsClient;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

@Service
public class MarvelService {
    private static final String PUBLIC_KEY = "720bdf9852d83661fe5e5d57d9aba9ed";
    private static final String PRIVATE_KEY = "144fcb44515c6b5dc3ba4bc959612a90c4895215";

    @Autowired
    private MarvelComicsClient client;

    @Transactional
    public Comic findComic(Long comicId) {
        Long timeStamp = new Date().getTime();

        ComicsResponse response = client.getComic(comicId, timeStamp, PUBLIC_KEY, buildHash(timeStamp));

        ResultsResponse result = response.getData().getResults().get(0);
        Comic comic = new Comic();
        comic.setComicId(result.getId());
        if(result.getTitle().isBlank())
            comic.setTitle("N/A");
        else
            comic.setTitle(result.getTitle());
        if(!result.getCreators().getItems().isEmpty()) {
            String creators = result.getCreators().getItems().get(0).getName();
            for (CreatorSummary summary : result.getCreators().getItems()) {
                creators = creators + ", " + summary.getName();
                ;
            }
            comic.setCreators(creators);
        } else {
            throw new ComicNotFoundException("Autores não presentes na APi Marvel, não é possivel criar o exemplar ou cadastrar a comic");
        }
        comic.setPrice(result.getPrices().get(0).getPrice());
        if(result.getDescription().isBlank())
            comic.setDescription("N/A");
        else
            comic.setDescription(result.getDescription());
        if(result.getIsbn().isBlank())
            throw new ISBNNotFoundExeception("ISBN não retornado pela API Marvel");
        else
            comic.setIsbn(result.getIsbn());

        return comic;

    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }


}
