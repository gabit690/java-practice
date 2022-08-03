package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TierGrouping<T> {

    private int _totalLevels;

    private int _totalElements;

    private List< Set<T> > _levels;

    public TierGrouping() {
        this._levels = new ArrayList<>();
    }

    public int getTotalLevels() {
        return _totalLevels;
    }

    public int getTotalElements() {
        return _totalElements;
    }

    public List< Set<T> > getLevels() {
        return _levels;
    }

    public void addElement(T element, int level) {
        if (level <= 0 || level > (this._totalLevels + 1)) {
            System.out.println("level out of limits");
            return;
        }

        if (level == this._totalLevels + 1) {
            System.out.println("New level: " + level);
            this._levels.add(new HashSet<>());
            this._totalLevels++;
        }

        if (this._levels.get(level - 1).add(element)) {
            this._totalElements++;
            System.out.println("NEW element");
        } else {
            System.out.println("Same element");
        }
    }

    public boolean removeElement(T element, int levelNumber) {

        if (levelNumber <= 0 || levelNumber > this._totalLevels) {
            System.out.println("level out of limits");
            return false;
        } else {

            Set<T> level = this._levels.get(levelNumber - 1);

            if(level.remove(element)) {
                this._totalElements--;

                if (level.size() == 0) {
                    System.out.println("One level was erased");
                    this._levels.remove(levelNumber - 1);
                    this._totalLevels--;
                }

                return true;
            } else {
                System.out.println("Element doesn't exist");
                return false;
            }

        }

    }

    @Override
    public String toString() {
        return "TierGrouping{" +
                "_totalLevels=" + _totalLevels +
                ", _totalElements=" + _totalElements +
                ", _levels=" + _levels +
                '}';
    }
}
