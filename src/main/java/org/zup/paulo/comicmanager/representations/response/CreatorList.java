package org.zup.paulo.comicmanager.representations.response;

import java.util.List;

public class CreatorList {

    private int available;
    private int returned;
    private String collectionURI;
    private List<CreatorSummary>  items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<CreatorSummary> getItems() {
        return items;
    }
}
