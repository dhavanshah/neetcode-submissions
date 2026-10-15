class TimeMap {

    private Map<String, List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.put(key, timeMap.get(key)).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {

        List<Pair> values = timeMap.getOrDefault(key, new ArrayList<>());

        int low = 0;
        int high = values.size() - 1;
        String result = "";

        while(low <= high) {

            int mid = (low + high) / 2;

            if(values.get(mid).getKey() == timestamp) {
                return values.get(mid).getValue();
            }

            if(values.get(mid).getKey() <= timestamp) {

                result = values.get(mid).getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return result;


        
    }

    static class Pair {

    private final int key;
    private final String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
}
