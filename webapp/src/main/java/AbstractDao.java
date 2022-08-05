import java.util.List;

public interface AbstractDao<T>{
    void create(T obj);
    List<T> retrieve();
    void update(T obj);
    void delete(T obj);
}