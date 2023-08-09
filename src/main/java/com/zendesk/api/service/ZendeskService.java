package com.zendesk.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zendesk.api.model.Comment;
import com.zendesk.api.model.TicketPatchRequest;
import com.zendesk.api.model.ZendeskResponse;

import java.util.Base64;
import java.util.List;

@Service
public class ZendeskService {

    @Value("${zendesk.url}")
    private String zendeskUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Comment> getComments(Long ticketId, String username, String password) {
        String url = zendeskUrl + "/tickets/" + ticketId + "/comments";
        HttpHeaders headers = createAuthHeaders(username, password);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<ZendeskResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ZendeskResponse.class);
        return response.getBody().getComments();
    }

    public void addCommentToTicket(Long ticketId, TicketPatchRequest ticketRequest, String username, String password) {
        String url = zendeskUrl + "/tickets/" + ticketId;
        HttpHeaders headers = createAuthHeaders(username, password);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-HTTP-Method-Override", "PATCH");
        
        HttpEntity<TicketPatchRequest> entity = new HttpEntity<>(ticketRequest, headers);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, entity, Void.class);
        
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Failed to add comment. HTTP error code: " + response.getStatusCode());
        }
    }

    private HttpHeaders createAuthHeaders(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }
}
