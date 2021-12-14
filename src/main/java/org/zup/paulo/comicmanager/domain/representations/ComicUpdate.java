package org.zup.paulo.comicmanager.domain.representations;

import org.zup.paulo.comicmanager.domain.Comic;

import java.util.Objects;

public class ComicUpdate {

    private Long comicId;

    private String title;

    private String creators;

    private Float price;

    private String isbn;

    private String description;

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return getComicId().equals(comic.getComicId()) && getTitle().equals(comic.getTitle()) && getIsbn().equals(comic.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComicId(), getTitle(), getIsbn());
    }

    @Override
    public String toString() {
        return "Comic{" +
                "comicId=" + comicId +
                ", título='" + title + '\'' +
                ", autores=" + creators +
                ", preco=" + price +
                ", isbn='" + isbn + '\'' +
                ", descricao='" + description + '\'' +
                '}';
    }
}

