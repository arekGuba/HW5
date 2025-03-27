/******************************************************************
 *
 *   Arek Gubala / COMP 272-001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

 import java.util.*;

 class ProblemSolutions {
 
     /**
      * Method: isSubset()
      *
      * Given two arrays of integers, A and B, return whether
      * array B is a subset if array A. Example:
      *      Input: [1,50,55,80,90], [55,90]
      *      Output: true
      *      Input: [1,50,55,80,90], [55,90, 99]
      *      Output: false
      *
      * The solution time complexity must NOT be worse than O(n).
      * For the solution, use a Hash Table.
      *
      * @param list1 - Input array A
      * @param list2 - input array B
      * @return      - returns boolean value B is a subset of A.
      */
 
     public boolean isSubset(int list1[], int list2[]) {
 
         // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

         HashSet<Integer> set = new HashSet<>();

        // Every element in list2 must be present in list1
        // 1. put list1 in a set
        // 2. for-each loop through list2, checking if the current element exists in the set of list1
        // 3.  if it reaches the end of the loop, true, else false if loop prematurely ends

        // all elements in list1 are put into a set
         for (int i : list1){
            set.add(i);
         }
         
         // loop, checking if every element in list2 is in the hashSet (consisting of list1's elements)
         for (int i : list2){
            if (!set.contains(i)){ // if an element in list2 isn't found in the set, B isn't subset of A
                return false;
            }
         }

         return true;
     }
 
 
     /**
      * Method: findKthLargest
      *
      * Given an Array A and integer K, return the k-th maximum element in the array.
      * Example:
      *      Input: [1,7,3,10,34,5,8], 4
      *      Output: 7
      *
      * @param array - Array of integers
      * @param k     - the kth maximum element
      * @return      - the value in the array which is the kth maximum value
      */
 
     public int findKthLargest(int[] array, int k) {
 
         // ADD YOUR CODE HERE

         // make a maxheap by reverseOrdering a priority queue, made up of the elements in array.
         // we'll pop the max off the heap k many times to get the k-th max value in array
         PriorityQueue<Integer> pq = new PriorityQueue<>(array.length, Collections.reverseOrder());
         for (int i : array){
            pq.add(i);
         }

         int pop = 0; // integer to be popped off & returned
         if (k < array.length) { // make sure k isn't beyond bounds of array
             for (int i = 0; i < k; i++) {
                pop = pq.poll();
             }
             
         } else { // if k is beyond array's bounds, return -1
            return -1;
         }
 
         return pop;
     }
 
 
     /**
      * Method: sort2Arrays
      *
      * Given two arrays A and B with n and m integers respectively, return
      * a single array of all the elements in A and B in sorted order. Example:
      *      Input: [4,1,5], [3,2]
      *      Output: 1 2 3 4 5
      *
      * @param array1    - Input array 1
      * @param array2    - Input array 2
      * @return          - Sorted array with all elements in A and B.
      */
 
     public int[] sort2Arrays(int[] array1, int[] array2) {

         // ADD YOU CODE HERE


         // create a minheap made up of all elements in both arrays. afterwards, pop the min
         // off of the heap into a new sorted array to be returned
         int n = array1.length;
         int m = array2.length;
         PriorityQueue<Integer> pq = new PriorityQueue<>(n + m);
         int[] sorted = new int[n + m];

         // add elements from both arrays into pq (the heap)
         for (int i : array1) {
             pq.add(i);
         }
         for (int i : array2) {
             pq.add(i);
         }

         // pop elements off of the sorted heap into the sorted array, then return it
         for (int i = 0; i < n + m; i++) {
             sorted[i] = pq.poll();
         }

         return sorted;
     }

 }
