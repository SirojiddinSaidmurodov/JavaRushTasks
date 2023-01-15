package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever retriever;
    LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(10);
    }

    @Override
    public Object retrieve(long id) {
        Object o = lruCache.find(id);
        if (o == null) {
            o = retriever.retrieve(id);
            lruCache.set(id, o);
        }
        System.out.println("Returning cached object!");
        return (o);
    }
}
