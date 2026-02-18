class Solution {
public:
    int overlapInt(vector<vector<int>>& intervals) {
        map<int, int> events;

        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            events[start]++;      // start
            events[end + 1]--;    // inclusive fix
        }

        int active = 0, ans = 0;

        for (auto it = events.begin(); it != events.end(); it++) {
            active += it->second;
            ans = max(ans, active);
        }

        return ans;
    }
};