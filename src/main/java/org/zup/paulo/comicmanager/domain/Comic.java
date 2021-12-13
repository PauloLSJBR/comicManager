package org.zup.paulo.comicmanager.domain;

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
    private Long comicId;

    @NotBlank(message = "Titulo é obrigatorio")
    private String título;

    @NotBlank(message = "Autores é obrigatorio")
    private String autores;

    @NotNull(message = "Preço é obrigatorio")
    private Float preco;

//    @NotBlank(message = "ISBN é obrigatorio")
    private String isbn;

    private String descricao;

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return getComicId().equals(comic.getComicId()) && getTítulo().equals(comic.getTítulo()) && getIsbn().equals(comic.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComicId(), getTítulo(), getIsbn());
    }

    @Override
    public String toString() {
        return "Comic{" +
                "ComicId=" + comicId +
                ", título='" + título + '\'' +
                ", autores='" + autores + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
