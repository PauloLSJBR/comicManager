package org.zup.paulo.comicmanager.domain.representations;

import org.zup.paulo.comicmanager.domain.Comic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ComicResult {

    private Long comicId;

    private String title;

    private String creators;

    private Float price;

    private String description;

    private String isbn;

    private Boolean descontoApl = Boolean.FALSE;

    public ComicResult() {
    }

    public ComicResult(Comic comic) {
        this.comicId = comic.getComicId();
        this.title = comic.getTitle();
        this.creators = comic.getCreators();
        this.price = comic.getPrice();
        this.description = comic.getDescription();
        this.isbn = comic.getIsbn();
    }

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

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
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

    public Boolean getDescontoApl() {
        return descontoApl;
    }

    public void setDescontoApl(Boolean descontoApl) {
        this.descontoApl = descontoApl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicResult that = (ComicResult) o;
        return getComicId().equals(that.getComicId()) && getIsbn().equals(that.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComicId(), getIsbn());
    }

    @Override
    public String toString() {
        return "ComicResult{" +
                "ComicId=" + comicId +
                ", título='" + title + '\'' +
                ", autores='" + creators + '\'' +
                ", preco=" + price +
                ", descricao='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descontoApl=" + descontoApl +
                '}';
    }
}
