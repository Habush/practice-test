package com.practicetest.app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abdulrahman Semrie
 **/
public class GenericTreeTest {

    @Test
    public void canVerifyParent(){

        GenericTree<Integer> testTree = new GenericTree<Integer>();

       testTree.createRootNode(1);

        GenericNode<Integer> a = testTree.getRoot();

        GenericNode<Integer> b = testTree.createNode(2, a);
        GenericNode<Integer> c = testTree.createNode(3, a);
        GenericNode<Integer> d = testTree.createNode(4, b);
        GenericNode<Integer> e = testTree.createNode(5, b);
        GenericNode<Integer> f = testTree.createNode(6, b);
        GenericNode<Integer> g = testTree.createNode(7, c);
        GenericNode<Integer> h = testTree.createNode(8, g);

        //C is the direct parent of g
        assertTrue(testTree.isNodeParentOf(c,g));

        //a(root) is the indirect parent of d
        assertTrue(testTree.isNodeParentOf(a, d));

        //b is not the parent of h in any way
        assertFalse(testTree.isNodeParentOf(b, h));

    }

     @Test
    public void canGetChildren(){
        GenericTree<Integer> testTree = new GenericTree<Integer>();

        testTree.createRootNode(1);

        GenericNode<Integer> a = testTree.getRoot();

        GenericNode<Integer> b = testTree.createNode(2, a);
        GenericNode<Integer> c = testTree.createNode(3, a);
        GenericNode<Integer> d = testTree.createNode(4, b);
        GenericNode<Integer> e = testTree.createNode(5, b);
        GenericNode<Integer> f = testTree.createNode(6, b);
        GenericNode<Integer> g = testTree.createNode(7, c);
        GenericNode<Integer> h = testTree.createNode(8, g);


        //b has three children, namely, d, e, f
        assertEquals(testTree.getChildren(b).size(), 3);
        assertTrue(testTree.getChildren(b).contains(e));
    }

    @Test
    public void canSearchNodeDFS(){
        GenericTree<Integer> testTree = new GenericTree<Integer>();

        testTree.createRootNode(1);

        GenericNode<Integer> a = testTree.getRoot();

        GenericNode<Integer> b = testTree.createNode(2, a);
        GenericNode<Integer> c = testTree.createNode(3, a);
        GenericNode<Integer> d = testTree.createNode(4, b);
        GenericNode<Integer> e = testTree.createNode(5, b);
        GenericNode<Integer> f = testTree.createNode(6, b);
        GenericNode<Integer> g = testTree.createNode(7, c);
        GenericNode<Integer> h = testTree.createNode(8, g);


        assertEquals(GenericTree.depthFirstSearch(testTree, 4), d);
        assertNull(GenericTree.depthFirstSearch(testTree, 9));
    }

    @Test
    public void canSearchNodeBFS(){
       GenericTree<Integer> testTree = new GenericTree<Integer>();

        testTree.createRootNode(1);

        GenericNode<Integer> a = testTree.getRoot();

        GenericNode<Integer> b = testTree.createNode(2, a);
        GenericNode<Integer> c = testTree.createNode(3, a);
        GenericNode<Integer> d = testTree.createNode(4, b);
        GenericNode<Integer> e = testTree.createNode(5, b);
        GenericNode<Integer> f = testTree.createNode(6, e);
        GenericNode<Integer> g = testTree.createNode(7, c);
        GenericNode<Integer> h = testTree.createNode(8, g);

        assertEquals(GenericTree.breadthFirstSearch(testTree, 5), e);
        assertNull(GenericTree.breadthFirstSearch(testTree, 9));
    }
}
