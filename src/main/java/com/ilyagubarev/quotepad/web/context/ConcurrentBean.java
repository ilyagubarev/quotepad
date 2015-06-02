package com.ilyagubarev.quotepad.web.context;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class ConcurrentBean extends Bean {

    private final ReentrantReadWriteLock lock;

    public ConcurrentBean() {
        this.lock = new ReentrantReadWriteLock();
    }

    protected void lockWhileRead() {
        lock.readLock().lock();
    }

    protected void lockWhileWrite() {
        lock.writeLock().lock();
    }

    protected void unlockAfterRead() {
        lock.readLock().unlock();
    }

    protected void unlockAfterWrite() {
        lock.writeLock().unlock();
    }
}
