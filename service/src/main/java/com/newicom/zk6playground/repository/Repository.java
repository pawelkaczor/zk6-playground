package com.newicom.zk6playground.repository;

import java.util.List;

/**
 * @author Pawel Kaczor
 */
public interface Repository<E> {

    List<E> getAll();
    
    void add(E entity);
}
