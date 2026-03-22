from math import comb

class Solution:
    def countBSTs(self, arr):
        """
        arr: list of distinct integers
        return: list where ith element = number of BSTs with arr[i] as root
        """
        def catalan(n):
            return comb(2 * n, n) // (n + 1)

        result = []
        for root in arr:
            left_count = sum(1 for x in arr if x < root)
            right_count = sum(1 for x in arr if x > root)
            result.append(catalan(left_count) * catalan(right_count))
        return result