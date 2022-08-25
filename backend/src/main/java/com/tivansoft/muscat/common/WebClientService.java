package com.tivansoft.muscat.common;

import com.tivansoft.muscat.common.vo.CommonVO;
import com.tivansoft.muscat.common.vo.RestTempVO;
import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    public static final String BASE_URL = "http://localhost:9100"; // 타겟 생기면 거기로 변경 (양채형 PC로 변경할까 생각중)

    // 예제 12.10
    public String getName() {

        WebClient webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return webClient.get()
                .uri("/api/v1/crud-api")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getNameWithPathVariable() {

        WebClient webClient = WebClient.create(BASE_URL);

        ResponseEntity<String> responseEntity = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/{name}")
                        .build("Flature"))
                .retrieve().toEntity(String.class).block();

        ResponseEntity<String> responseEntity1 = webClient.get()
                .uri("/api/v1/crud-api/{name}", "Flature")
                .retrieve()
                .toEntity(String.class)
                .block();

        return responseEntity.getBody();
    }

    public String getNameWithParameter() {

        WebClient webClient = WebClient.create(BASE_URL);

        return webClient.get().uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
                        .queryParam("name", "Flature")
                        .build())
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(String.class);
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                })
                .block();
    }

    // 예제 12.11
    public ResponseEntity<RestTempVO> postWithParamAndBody() {

        WebClient webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        CommonVO commonVO = new CommonVO();
        commonVO.setUserId("flature!!");
        commonVO.setPswd("flature@gmail.com");
        commonVO.setMsg("Around Hub Studio");

        return webClient.post().uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
                        .queryParam("name", "Flature")
                        .queryParam("email", "flature@wikibooks.co.kr")
                        .queryParam("organization", "Wikibooks")
                        .build())
                .bodyValue(commonVO)
                .retrieve()
                .toEntity(RestTempVO.class)
                .block();
    }

    public ResponseEntity<RestTempVO> postWithHeader() {

        WebClient webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        CommonVO commonVO = new CommonVO();
        commonVO.setUserId("flature!!");
        commonVO.setPswd("flature@gmail.com");
        commonVO.setMsg("Around Hub Studio");

        return webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/add-header")
                        .build())
                .bodyValue(commonVO)
                .header("my-header", "Wikibooks API")
                .retrieve()
                .toEntity(RestTempVO.class)
                .block();
    }

    public void cloneWebClient() {
        WebClient webClient = WebClient.create(BASE_URL);
        WebClient clone = webClient.mutate().build();
    }
}