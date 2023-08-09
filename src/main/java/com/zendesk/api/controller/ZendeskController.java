package com.zendesk.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zendesk.api.model.Comment;
import com.zendesk.api.model.TicketPatchRequest;
import com.zendesk.api.service.ZendeskService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class ZendeskController {

    private final ZendeskService zendeskService;

    @Autowired
    public ZendeskController(ZendeskService zendeskService) {
        this.zendeskService = zendeskService;
    }

    @GetMapping("/{ticketId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long ticketId, @RequestHeader("Authorization") String authHeader) {
        String[] credentials = extractCredentials(authHeader);
        List<Comment> comments = zendeskService.getComments(ticketId, credentials[0], credentials[1]);
        return ResponseEntity.ok(comments);
    }

    @PatchMapping("/{ticketId}")
    public ResponseEntity<String> addCommentToTicket(@PathVariable Long ticketId, @RequestBody TicketPatchRequest ticketRequest, @RequestHeader("Authorization") String authHeader) {
        String[] credentials = extractCredentials(authHeader);
        zendeskService.addCommentToTicket(ticketId, ticketRequest, credentials[0], credentials[1]);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comment added successfully.");
    }

    private String[] extractCredentials(String authHeader) {
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        final String[] values = credentials.split(":", 2);
        return values;
    }

}
