package com.icai.practicas.controller;

import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testing_processController_step1_then_ok(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        DataRequest dataRequest = new DataRequest("Breton", "81356846G", "695777555");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
        ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

        //Then
        String expectedResult = "OK";
        DataResponse expectedResponse = new DataResponse(expectedResult);

        then(result.getBody().result()).isEqualTo(expectedResult);
        then(result.getBody()).isEqualTo(expectedResponse);

    }

    @Test
    public void testing_processController_step1_then_ko(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
        DataRequest dataRequest = new DataRequest("Breton", "025770ffE", "6667778jj88");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
        ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);


        //Then
        String expectedResult = "KO";
        DataResponse expectedResponse = new DataResponse(expectedResult);

        then(result.getBody().result()).isEqualTo(expectedResult);
        then(result.getBody()).isEqualTo(expectedResponse);

    }

    @Test
    public void testing_processController_step1__legacy_then_ok(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add("fullName", "Breton");
        data.add("dni", "81356846G");
        data.add("telefono", "695777555");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //Then
        String expectedResult = ResponseHTMLGenerator.message1;
        then(result.getBody()).isEqualTo(expectedResult);

    }

    @Test
    public void testing_processController_step1__legacy_then_ko(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add("fullName", "Breton");
        data.add("dni", "025770ffE");
        data.add("telefono", "6667778jj88");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //Then
        String expectedResult = ResponseHTMLGenerator.message2;
        then(result.getBody()).isEqualTo(expectedResult);

    }

}