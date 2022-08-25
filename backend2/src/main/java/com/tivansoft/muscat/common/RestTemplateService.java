package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;

import com.tivansoft.muscat.common.vo.RestTempVO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;



@Service
public class RestTemplateService {
    
    //getForObject
    //GET
    //주어진 URL 주소로 HTTP GET 메서드로 객체로 결과를 반환받는다
    
    //getForEntity
    //GET
    //주어진 URL 주소로 HTTP GET 메서드로 결과는 ResponseEntity로 반환받는다
    
    //postForLocation
    //POST
    //POST 요청을 보내고 결과로 헤더에 저장된 URI를 결과로 반환받는다
    
    //postForObject
    //POST
    //POST 요청을 보내고 객체로 결과를 반환받는다
    
    //postForEntity
    //POST
    //POST 요청을 보내고 결과로 ResponseEntity로 반환받는다
    
    //delete
    //DELETE
    //주어진 URL 주소로 HTTP DELETE 메서드를 실행한다
    
    //headForHeaders
    //HEADER
    //헤더의 모든 정보를 얻을 수 있으면 HTTP HEAD 메서드를 사용한다
    
    //put
    //PUT
    //주어진 URL 주소로 HTTP PUT 메서드를 실행한다
    
    //patchForObject
    //PATCH
    //주어진 URL 주소로 HTTP PATCH 메서드를 실행한다
    
    //optionsForAllow
    //OPTIONS
    //주어진 URL 주소에서 지원하는 HTTP 메서드를 조회한다
    
    //exchange
    //any
    //HTTP 헤더를 새로 만들 수 있고 어떤 HTTP 메서드도 사용가능하다
    
    //execute
    //any
    //Request/Response 콜백을 수정할 수 있다

    public static final String BASE_URL = "http://localhost:9000"; // 타겟 생기면 거기로 변경 (양채형 PC로 변경할까 생각중)

    // get
    public RestTempVO getObject() throws Exception {

        // uri 주소 생성
        URI uri = UriComponentsBuilder
                .fromUriString(BASE_URL)
                .path("/vue/getReceipt")
                //.queryParam("name", "steve")  // query parameter가 필요한 경우 이와 같이 사용
                //.queryParam("age", 10)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplete = new RestTemplate();

        // VO 형식으로 받을 수 있음
        ResponseEntity<RestTempVO> result = restTemplete.getForEntity(uri, RestTempVO.class);

        //Map<String, Object> result = restTemplete.getForObject(uri, Map.class);

        // entity로 데이터를 가져오겠다(Get)~~
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    // post
    public RestTempVO postObject() throws Exception {

        // uri 주소 생성
        URI uri = UriComponentsBuilder
                .fromUriString(BASE_URL)
                .path("/vue/receipt")
                .queryParam("userId", "조승철")
                .encode() // 기본 UTF-8
                .build()
                //.expand("01067113103", " 조승철")
                .toUri();

        System.out.println(uri.toString());

        CommonVO commmonVo = new CommonVO();
        commmonVo.setUserId("조승철");
        commmonVo.setMsg("REST TEMPLATE TEST!!");

        RestTemplate restTemplete = new RestTemplate();

        // VO 형식으로 받을 수 있음
        ResponseEntity<RestTempVO> result = restTemplete.postForEntity(uri, commmonVo, RestTempVO.class);

        //Map<String, Object> result = restTemplete.getForObject(uri, Map.class);

        System.out.println("result code :::: " + result.getStatusCode());
        System.out.println("result body :::: " + result.getBody());

        return result.getBody();
    }

}
