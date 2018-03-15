package com.practicetest.app;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Abdulrahman Semrie
 **/
public class TreeTest {

    @Test
    public void canVerifyParent(){
        //Create an empty Tree with no root
        Tree testTree = new Tree();
        //set Node A as the root
        testTree.createRootNode("A");
        Node a = testTree.getRoot();

        Node b = testTree.createNode("B", a);
        Node c = testTree.createNode("C", a);
        Node d = testTree.createNode("D", b);
        Node e = testTree.createNode("E", b);
        Node f = testTree.createNode("F", b);
        Node g = testTree.createNode("G", c);
        Node h = testTree.createNode("H", g);

        //C is the direct parent of g
        assertTrue(testTree.isNodeParentOf(c,g));

        //a(root) is the indirect parent of d
        assertTrue(testTree.isNodeParentOf(a, d));

        //b is not the parent of h in any way
        assertFalse(testTree.isNodeParentOf(b, h));
    }

    @Test
    public void canGetChildren(){
       //Create an empty Tree with no root
        Tree testTree = new Tree();
        //set Node A as the root
        testTree.createRootNode("A");
        Node a = testTree.getRoot();

        Node b = testTree.createNode("B", a);
        Node c = testTree.createNode("C", a);
        Node d = testTree.createNode("D", b);
        Node e = testTree.createNode("E", b);
        Node f = testTree.createNode("F", b);
        Node g = testTree.createNode("G", c);
        Node h = testTree.createNode("H", g);

        //b has three children, namely, d, e, f
        assertEquals(testTree.getChildren(b).size(), 3);
        assertTrue(testTree.getChildren(b).contains(e));
    }

    @Test
    public void canSearchNodeDFS(){
        //Create an empty Tree with no root
        Tree testTree = new Tree();
        //set Node A as the root
        testTree.createRootNode("A");
        Node a = testTree.getRoot();

        Node b = testTree.createNode("B", a);
        Node c = testTree.createNode("C", a);
        Node d = testTree.createNode("D", b);
        Node e = testTree.createNode("E", b);
        Node f = testTree.createNode("F", b);
        Node g = testTree.createNode("G", c);
        Node h = testTree.createNode("H", g);

        assertEquals(Tree.dfs(testTree, "D"), d);
    }

    @Test
    public void canSearchNodeBFS(){
       //Create an empty Tree with no root
        Tree testTree = new Tree();
        //set Node A as the root
        testTree.createRootNode("A");
        Node a = testTree.getRoot();

        Node b = testTree.createNode("B", a);
        Node c = testTree.createNode("C", a);
        Node d = testTree.createNode("D", b);
        Node e = testTree.createNode("E", b);
        Node f = testTree.createNode("F", b);
        Node g = testTree.createNode("G", c);
        Node h = testTree.createNode("H", g);

        assertEquals(Tree.dfs(testTree, "E"), e);
        assertNull(Tree.dfs(testTree, "J"));
    }
}
