package com.eurofunk.c4.dto;

import java.util.Map;

public class ClientDTO {
    private String clientId;
    private String nodeId;
    private Map<String, String> clientTags;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Map<String, String> getClientTags() {
        return clientTags;
    }

    public void setClientTags(Map<String, String> clientTags) {
        this.clientTags = clientTags;
    }
}
