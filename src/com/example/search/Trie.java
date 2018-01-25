package com.example.search;

/**
 * Created by geeche on 2018/1/25.
 */
public class Trie {

    class Node{
        private char c;
        private int frequency = 0;
        private Node[] childrens;
        public Node(){
            this('#');
        }
        public Node(char c){
            this.c = c;
            this.childrens = new Node[26];
        }
        public boolean hasChild(){
            int empty = 0;
            for(Node node : childrens){
                if(node == null){
                    empty++;
                }
            }
            return empty != 26;
        }
        public void frequencyInc(){
            frequency++;
        }
    }

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node nextNode = root;
        if(word == null){
            return;
        }
        int length = word.length();
        int idx;
        for(int i=0;i<length;i++){
            char c = word.charAt(i);
            idx = c - 'a';
            if(nextNode.childrens[idx] == null){
                Node node = new Node(c);
                nextNode.childrens[idx] = node;
            }
            nextNode = nextNode.childrens[idx];
        }
        nextNode.frequencyInc();
    }

    public void remove(String word){
        char c = word.charAt(0);
        Node node = root;
        if(node.childrens[c-'a'] != null){
            node = node.childrens[c-'a'];
        }else{
            return;
        }
        remove(word,0,node);
    }

    private void remove(String word,int idx,Node nextNode){
        if(word == null){
            return;
        }
        if(idx == word.length()-1){
            return;
        }
        remove(word,idx+1, nextNode.childrens[word.charAt(idx+1)-'a']);
        if(!nextNode.hasChild()){
            nextNode = null;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");
        trie.remove("abc");
        System.out.print("over");
    }

}
