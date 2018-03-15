package com.practicetest.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Abdulrahman Semrie
 **/

public class Tree {

    private Node root;
    private List<Node> nodes = new ArrayList<Node>(); //non-root nodes


    public Node createNode(String val, Node parent){
        Node n =  new Node(val, parent);
        this.nodes.add(n);
        return n;
    }

    public void createRootNode(String val){
        if(this.root == null){
            this.root = new Node(val, null);
        }
        else{
            this.root.setValue(val);
        }
    }

    public List<Node> getChildren(Node node){
        List<Node> children = new ArrayList<Node>();
        for(Node n: nodes){
            if(n.getParent().equals(node)){
                children.add(n);
            }
        }
        return children;
    }

    public boolean isNodeParentOf(Node nodeA, Node nodeB){
        while(nodeB.getParent() != null){
            if(nodeB.getParent().equals(nodeA))
                return true;
            nodeB = nodeB.getParent();
        }
        return false;
    }

    public static Node dfs(Tree tree, String val){
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(tree.getRoot());

        while(!nodeStack.empty()){
            Node current = nodeStack.pop();
            if(current.getValue().equals(val)){
                return current;
            }
            for(Node n: tree.getChildren(current)){
                nodeStack.push(n);
            }
        }

        return null;

    }

    public static Node bfs(Tree tree, String val){
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(tree.getRoot());

        while(!nodes.isEmpty()){
            Node current = nodes.get(nodes.size() - 1);

            if(current.getValue().equals(val)){
                return current;
            }

            nodes.addAll(tree.getChildren(current));
        }
        return null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
