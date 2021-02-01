package service;

import java.util.List;

public interface Intersect <T>{

    List<T> getAllIntersects(List<T> allT);

    T checkIntersection(T first, T second);
}
