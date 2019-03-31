package com.sherlock.thoughtgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class GameController {

    private RestTemplate restTemplate;
    @Autowired
    private Challenge3 challenge3;

    @Autowired
    private Challenge4 challenge4;

    public GameController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/mySolution3")
    public String mySolution3() throws IOException {
        return postSolution(challenge3.solve(getInput()));
    }

    @GetMapping("/mySolution4")
    public String mySolution4() throws IOException {
        return postSolution(challenge4.solve(getInput()));
    }


    private String postSolution(HashMap<String, Integer> outputMap) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("userId", "BS3AENj8x");
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add(HttpHeaders.ACCEPT_ENCODING,"gzip");

        HttpEntity<HashMap<String, Integer>> postEntity = new HttpEntity<HashMap<String, Integer>>(outputMap, requestHeaders);

        ResponseEntity<String> outResponse = restTemplate.exchange
                ("https://http-hunt.thoughtworks-labs.net/challenge/output",
                        HttpMethod.POST,
                        postEntity,String.class);


        return outResponse.getBody();
    }

    private List<Input> getInput() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("userId", "BS3AENj8x");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<List<Input>> response = restTemplate.exchange
                ("https://http-hunt.thoughtworks-labs.net/challenge/input",
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<List<Input>>(){});
        return response.getBody();
    }
}
