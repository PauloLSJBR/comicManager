package org.zup.paulo.comicmanager.domain.representations;

import java.util.Objects;

public class ComicRequest {

    private Long comicId;

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicRequest that = (ComicRequest) o;
        return Objects.equals(getComicId(), that.getComicId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComicId());
    }

    @Override
    public String toString() {
        return "ComicRequest{" +
                "comicId=" + comicId +
                '}';
    }
}

