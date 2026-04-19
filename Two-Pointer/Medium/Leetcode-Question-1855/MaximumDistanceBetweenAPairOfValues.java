class MaximumDistanceBetweenAPairOfValues {

    public int maxDistance(int[] nums1, int[] nums2) {

        // This is a two-pointer problem.
        // We want to find the maximum distance (j - i)
        // such that i <= j and nums1[i] <= nums2[j]

        // Pointer for nums1 (smaller array values)
        int pointerNums1 = 0;

        // Pointer for nums2 (used to explore maximum distance)
        int pointerNums2 = 1;

        // Traverse nums2 while keeping pointerNums1 valid
        for (; pointerNums1 < nums1.length && pointerNums2 < nums2.length; pointerNums2++) {

            // If condition breaks (nums1[i] > nums2[j]),
            // move pointerNums1 forward to restore validity
            if (nums1[pointerNums1] > nums2[pointerNums2]) {
                pointerNums1++;
            }
        }

        // After loop ends, pointerNums2 is one step ahead,
        // so subtract 1 to get the valid distance
        return pointerNums2 - pointerNums1 - 1;
    }
}