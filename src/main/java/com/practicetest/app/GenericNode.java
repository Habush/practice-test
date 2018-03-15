package com.practicetest.app;

/**
 * Created by Abdulrahman Semrie
 **/
public class GenericNode<T> {

    private T value;
    private GenericNode parent;

    public GenericNode(T val, GenericNode<T> par){
        this.value = val;
        this.parent = par;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNode<T> getParent() {
        return parent;
    }

    public void setParent(GenericNode<T> parent) {
        this.parent = parent;
    }
}
