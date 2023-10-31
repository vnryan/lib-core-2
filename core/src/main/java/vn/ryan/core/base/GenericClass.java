package vn.ryan.core.base;

public class GenericClass<T> {
    private final Class<T> type;
    public GenericClass(Class<T> cls) {
        type = cls;
    }
    public Class<T> getType() {
        return type;
    }
}
