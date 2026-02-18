class Solution {
public:
    long long mergeCount(vector<int>& a, int left, int mid, int right) {
        vector<int> temp;
        int i = left, j = mid + 1;
        long long inv = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp.push_back(a[i++]);
            } else {
                temp.push_back(a[j++]);
                inv += (mid - i + 1);
            }
        }

        while (i <= mid) temp.push_back(a[i++]);
        while (j <= right) temp.push_back(a[j++]);

        for (int k = left; k <= right; k++)
            a[k] = temp[k - left];

        return inv;
    }

    long long mergeSortCount(vector<int>& a, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        long long inv = 0;

        inv += mergeSortCount(a, left, mid);
        inv += mergeSortCount(a, mid + 1, right);
        inv += mergeCount(a, left, mid, right);

        return inv;
    }

    long long inversionCount(vector<int> &arr) {
        return mergeSortCount(arr, 0, arr.size() - 1);
    }
};
