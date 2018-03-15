package com.practicetest.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Abdulrahman Semrie
 **/
public class GenericTree<T> {
    private GenericNode<T> root;
    private List<GenericNode<T>> nodes = new ArrayList<GenericNode<T>>(); //non-root nodes

    public GenericNode<T> createNode(T val, GenericNode<T> parent){
        GenericNode<T> n =  new GenericNode<T>(val, parent);
        this.nodes.add(n);
        return n;
    }

    public void createRootNode(T val){
        if(this.root == null){
            this.root = new GenericNode<T>(val, null);
        }
        else{
            this.root.setValue(val);
        }
    }

    public List<GenericNode<T>> getChildren(GenericNode<T> node){
        List<GenericNode<T>> children = new ArrayList<GenericNode<T>>();
        for(GenericNode<T> n: nodes){
            if(n.getParent().equals(node)){
                children.add(n);
            }
        }
        return children;
    }


    public boolean isNodeParentOf(GenericNode<T> nodeA, GenericNode<T> nodeB){
        while(nodeB.getParent() != null){
            if(nodeB.getParent().equals(nodeA))
                return true;
            nodeB = nodeB.getParent();
        }
        return false;
    }

    public static <T> GenericNode<T> depthFirstSearch(GenericTree<T> tree, T val){
        Stack<GenericNode<T>> nodeStack = new Stack<GenericNode<T>>();
        nodeStack.push(tree.getRoot());

        while(!nodeStack.empty()){
            GenericNode<T> current = nodeStack.pop();
            if(current.getValue().equals(val)){
                return current;
            }
            for(GenericNode<T> n: tree.getChildren(current)){
                nodeStack.push(n);
            }
        }

        return null;

    }

    public static <T> GenericNode<T> breadthFirstSearch(GenericTree<T> tree, T val){
        List<GenericNode<T>> nodes = new ArrayList<GenericNode<T>>();
        nodes.add(tree.getRoot());

        while(!nodes.isEmpty()){
            GenericNode<T> current = nodes.remove(0);

            if(current.getValue().equals(val)){
                return current;
            }

            nodes.addAll(tree.getChildren(current));
        }
        return null;
    }

    public GenericNode<T> getRoot() {
        return root;
    }

    public void setRoot(GenericNode<T> root) {
        this.root = root;
    }
}
