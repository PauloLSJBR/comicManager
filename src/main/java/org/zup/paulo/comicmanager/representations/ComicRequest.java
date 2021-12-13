package org.zup.paulo.comicmanager.representations;

import javax.validation.constraints.NotNull;

public class ComicRequest {

    @NotNull(message =  "A codigo de identificação e obrigatorio")
    private Long comicId;

    @NotNull(message = "Codigo do usuario necessario")
    private Long userId;

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
