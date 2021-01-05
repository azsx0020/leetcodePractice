package com.adohong.leetcode.practice.lrucache;

import com.adohong.leetcode.practice.common.datastructure.DListNode;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private DListNode dListNodeHead;
    private DListNode dListNodeTail;
    private HashMap<Integer, DListNode> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dListNodeHead = new DListNode();
        dListNodeTail = new DListNode();
        dListNodeTail.setVal(Integer.MAX_VALUE);
        dListNodeHead.setPrev(null);
        dListNodeHead.setVal(Integer.MAX_VALUE);
        dListNodeHead.setNext(dListNodeTail);
        dListNodeHead.getNext().setPrev(dListNodeHead);
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap == null || hashMap.get(key) == null) {
            return -1;
        } else {
            int res = hashMap.get(key).getVal();
            hashMap.get(key).getPrev().setNext(hashMap.get(key).getNext());
            hashMap.get(key).getNext().setPrev(hashMap.get(key).getPrev());
            DListNode tmp = dListNodeHead.getNext();
            dListNodeHead.setNext(hashMap.get(key));
            hashMap.get(key).setPrev(dListNodeHead);
            hashMap.get(key).setNext(tmp);
            tmp.setPrev(hashMap.get(key));

            return res;
        }

    }

    public void put(int key, int value) {
        if (hashMap.get(key) != null) {
            hashMap.get(key).setVal(value);
            hashMap.get(key).getPrev().setNext(hashMap.get(key).getNext());
            hashMap.get(key).getNext().setPrev(hashMap.get(key).getPrev());
            DListNode tmp = dListNodeHead.getNext();
            dListNodeHead.setNext(hashMap.get(key));
            hashMap.get(key).setPrev(dListNodeHead);
            hashMap.get(key).setNext(tmp);
            tmp.setPrev(hashMap.get(key));

        } else {
            DListNode newNode = new DListNode();
            newNode.setVal(value);
            hashMap.put(key, newNode);
            DListNode tmpNode = dListNodeHead.getNext();
            dListNodeHead.setNext(newNode);
            newNode.setPrev(dListNodeHead);
            newNode.setNext(tmpNode);
            tmpNode.setPrev(newNode);
        }
        if (hashMap.size() > capacity){
            while (hashMap.size() > capacity) {
                DListNode nodeToDelete = dListNodeTail.getPrev();
                dListNodeTail.getPrev().getPrev().setNext(dListNodeTail);
                dListNodeTail.setPrev(dListNodeTail.getPrev().getPrev());
                Map.Entry entryToRemove = null;
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry.getValue() == nodeToDelete) {
                        entryToRemove = entry;
                        break;
                    }
                }
                if (entryToRemove != null) {
                    hashMap.remove(entryToRemove.getKey(), entryToRemove.getValue());
                }
            }
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
