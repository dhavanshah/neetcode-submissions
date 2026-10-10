class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] pairs = new int[position.length][2];

        for(int i=0; i<position.length; i++) {

            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> fleet = new Stack<>();

        for(int[] p : pairs) {

            //double time = (target-p[0])/p[1];

            fleet.push((double) (target-p[0]) / p[1]);

            if(fleet.size()>=2 && fleet.peek() <= fleet.get(fleet.size()-2)) {
                fleet.pop();
            }
        }
        return fleet.size();
    }
}
