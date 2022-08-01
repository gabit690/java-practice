package generics;

import java.util.Set;

public class TierGrouping<T> {

    private int _totalLevels;

    private int _totalElements;

    private Set<T> _levels;

    public TierGrouping() {
    }

    public int getTotalLevels() {
        return _totalLevels;
    }

    public int getTotalElements() {
        return _totalElements;
    }

    public Set<T> getLevels() {
        return _levels;
    }

    public boolean addElement(T element, int level) {
        // Todo: Add element in level
        return true;
    }
}
