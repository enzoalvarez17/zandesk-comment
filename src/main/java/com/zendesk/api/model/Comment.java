package com.zendesk.api.model;

import java.util.List;

public class Comment {
    private Long id;
    private String type;
    private Long author_id;
    private String body;
    private String html_body;
    private String plain_body;
    private boolean isPublic; 
    private List<Object> attachments;
    private Long audit_id;
    private Via via;
    private String created_at;
    private Metadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHtml_body() {
        return html_body;
    }

    public void setHtml_body(String html_body) {
        this.html_body = html_body;
    }

    public String getPlain_body() {
        return plain_body;
    }

    public void setPlain_body(String plain_body) {
        this.plain_body = plain_body;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Long getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Long audit_id) {
        this.audit_id = audit_id;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}

class Via {
    private String channel;

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }

    private Source source;

    public Source getSource() {
        return source;
    }
    public void setSource(Source source) {
        this.source = source;
    }
}

class Source {
    private Object from;
    private Object to;
    private Object rel;

    public Object getFrom() {
        return from;
    }
    public void setFrom(Object from) {
        this.from = from;
    }
    
    public Object getTo() {
        return to;
    }
    public void setTo(Object to) {
        this.to = to;
    }

    public Object getRel() {
        return rel;
    }
    public void setRel(Object rel) {
        this.rel = rel;
    }
}

class Metadata {
    private Object system;
    private Object custom;

    public Object getSystem() {
        return system;
    }
    public void setSystem(Object system) {
        this.system = system;
    }

    public Object getCustom() {
        return custom;
    }
    public void setCustom(Object custom) {
        this.custom = custom;
    }
}

