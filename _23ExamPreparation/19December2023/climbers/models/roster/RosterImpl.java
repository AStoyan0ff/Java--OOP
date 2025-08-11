package climbers.models.roster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RosterImpl implements Roster {

    private final Collection<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }


    @Override
    public Collection<String> getPeaks() {
        return peaks;
    }
}
