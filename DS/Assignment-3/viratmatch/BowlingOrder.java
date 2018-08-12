package viratmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BowlingOrder {
    private Map<String, Integer> bowlerMap;
    private int noOfBallsViratPlay;

    /**
     * Class Constructor
     *
     * @param noOfBallsViratPlay
     * @param bowlerMap          to store bowler and quota for each bowler
     */
    public BowlingOrder(int noOfBallsViratPlay, Map<String, Integer> bowlerMap) throws AssertionError {
        if (noOfBallsViratPlay <= 0)
            throw new AssertionError("Number of balls should be more than zero");

        for (String bowler : bowlerMap.keySet()) {
            if (bowlerMap.get(bowler) < 0)
                throw new AssertionError("Number of balls cannot be negative");
        }

        if (sum(bowlerMap) >= noOfBallsViratPlay) {
            this.noOfBallsViratPlay = noOfBallsViratPlay;
            this.bowlerMap = bowlerMap;
        } else {
            throw new AssertionError("Insufficient bowlers!!");
        }
    }


    /**
     * calculates the bowling order in order to minimize the runs scored by Virat Kohli
     *
     * @return bowlingOrder
     */
    public List<String> bowlingOrder() {
        List<String> bowlingOrder = new ArrayList<>();

        for (int i = 0; i < noOfBallsViratPlay; i++) {
            String bowler = findBowler();
            bowlingOrder.add(bowler);
            bowlerMap.put(bowler, bowlerMap.get(bowler) - 1);
        }

        return bowlingOrder;
    }


    /**
     * helper method to find the bowler with the maximum number of balls left to bowl
     *
     * @return
     */
    private String findBowler() {
        int maxBalls = 0;
        String bowler = null;

        for (String bowlerName : bowlerMap.keySet()) {
            int balls = bowlerMap.get(bowlerName);
            if (maxBalls < balls) {
                maxBalls = balls;
                bowler = bowlerName;
            }
        }

        return bowler;
    }


    /**
     * helper method to add the total number of balls of all the bowlers
     *
     * @param bowlerMap
     * @return sum
     */
    private int sum(Map<String, Integer> bowlerMap) {
        int totalBalls = 0;
        for (String bowler : bowlerMap.keySet()) {
            totalBalls += bowlerMap.get(bowler);
        }
        return totalBalls;
    }
}