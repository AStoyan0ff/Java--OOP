package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class ClimbingImpl implements Climbing {


    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {

        Queue<String> mountainPeaks = new LinkedList<>(mountain.getPeaksList());

        for (Climber climber : climbers) {

            while (climber.canClimb() && !mountainPeaks.isEmpty()) {

                String currentPeak = mountainPeaks.poll();
                climber.getRoster().getPeaks().add(currentPeak);
                climber.climb();
            }
        }
        mountain.getPeaksList().clear();
        mountain.getPeaksList().addAll(mountainPeaks);
    }
}
