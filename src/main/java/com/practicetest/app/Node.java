package com.practicetest.app;

public class Node {

    private String value;
    private Node parent;

    public Node(String val, Node par){
        this.value = val;
        this.parent = par;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
