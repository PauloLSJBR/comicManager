package org.zup.paulo.comicmanager.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.zup.paulo.comicmanager.restclient.response.ComicsResponse;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface MarvelComicsClient {
	@GetMapping("/comics/{comicId}")
	public ComicsResponse getComic(@PathVariable(name = "comicId") Long comicId, @RequestParam(value = "ts") Long timeStamp,
								   @RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5);
}
