package org.zup.paulo.comicmanager.representations;

import org.zup.paulo.comicmanager.domain.Comic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ComicResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long ComicId;

    @NotBlank(message = "Titulo é obrigatorio")
    private String título;

    @NotBlank(message = "Autores é obrigatorio")
    private String autores;

    @NotNull(message = "Preço é obrigatorio")
    private Float preco;

    private String descricao;

    private String isbn;

    private Boolean descontoApl = Boolean.FALSE;

    public ComicResult() {
    }

    public ComicResult(Comic comic) {
        this.ComicId = comic.getComicId();
        this.título = comic.getTítulo();
        this.autores = comic.getAutores();
        this.preco = comic.getPreco();
        this.descricao = comic.getDescricao();
        this.isbn = comic.getIsbn();
    }

    public Long getComicId() {

        return ComicId;
    }

    public void setComicId(Long comicId) {
        ComicId = comicId;
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
                "ComicId=" + ComicId +
                ", título='" + título + '\'' +
                ", autores='" + autores + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descontoApl=" + descontoApl +
                '}';
    }
}
