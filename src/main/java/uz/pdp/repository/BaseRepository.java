package uz.pdp.repository;

import java.util.List;

public interface BaseRepository<T, R> {
    Boolean add(T item);
    List<R> list();
    R edite(Long id, T item);
    Boolean delete(Long id);
}
