package com.zendesk.api.model;

import java.util.List;

public class ZendeskResponse {
    private List<Comment> comments;
    private Object next_page;
    private Object previous_page;
    private int count;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Object getNext_page() {
        return next_page;
    }

    public void setNext_page(Object next_page) {
        this.next_page = next_page;
    }

    public Object getPrevious_page() {
        return previous_page;
    }

    public void setPrevious_page(Object previous_page) {
        this.previous_page = previous_page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

