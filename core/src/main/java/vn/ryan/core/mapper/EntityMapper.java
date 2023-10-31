package vn.ryan.core.mapper;

import java.util.List;

public interface EntityMapper<E, D>{
    D toDto(E e);
    E toEntity(D d);
    List<E> toListEntity(List<D> d);
    List<D> toListDto(List<E> e);
}
