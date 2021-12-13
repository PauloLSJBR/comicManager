package org.zup.paulo.comicmanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="exemplary")
public class Exemplary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exemplaryId;

    @ManyToOne
    private Comic comic;

    @ManyToOne
    private User user;

    public Long getExemplaryId() {
        return exemplaryId;
    }

    public void setExemplaryId(Long exemplaryId) {
        this.exemplaryId = exemplaryId;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplary exemplary = (Exemplary) o;
        return getExemplaryId().equals(exemplary.getExemplaryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExemplaryId());
    }

    @Override
    public String toString() {
        return "Exemplary{" +
                "exemplaryId=" + exemplaryId +
                ", comic=" + comic +
                ", user=" + user +
                '}';
    }
}
