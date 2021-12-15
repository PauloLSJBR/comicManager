package org.zup.paulo.comicmanager.domain;

import org.zup.paulo.comicmanager.domain.representations.ComicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="comic")
public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "Identificação é obrigatorio")
    private Long comicId;

    @NotBlank(message = "Titulo é obrigatorio")
    private String title;

    @NotBlank(message = "Autores é obrigatorio")
    private String creators;

    @NotNull(message = "Preço é obrigatorio")
    private Float price;

    @NotBlank(message = "ISBN é obrigatorio")
    private String isbn;

    private String description;

    public Comic() {
    }

    public Comic(ComicUpdate comicUpdate) {
        this.comicId = comicUpdate.getComicId();
        this.title = comicUpdate.getTitle();
        this.creators = comicUpdate.getCreators();
        this.price = comicUpdate.getPrice();
        this.isbn = comicUpdate.getIsbn();
        this.description = comicUpdate.getDescription();
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
