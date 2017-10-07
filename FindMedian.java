package com.java1995;

public class FindMedian {
	public static int[] nums1={1,3,7};
	public static int[] nums2={2,4,6};
	public static void main(String args[]){
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Á©¼ÓÒ»¿é
            int m = nums1.length;
            int n = nums2.length;
            int both = m + n;
        if(both%2 != 0){
            return findKth(nums1,nums2,both/2+1);
            
        }else{
            return (findKth(nums1,nums2,both/2)+findKth(nums1,nums2,both/2+1))/2.0;
        }
    }    
        public static int findKth(int[] nums1,int[] nums2,int k){
         //use i as a movement signal
            int m = nums1.length;
            int n = nums2.length;
            int p = 0; int q = 0;
            for(int i = 0; i < k-1 ;i++){
                if(p>=m && q<n){
                    q++;
                }else if(p<m && q>=n){
                    p++;
                }else if(nums1[p]<nums2[q]){
                    p++;
                }else{
                    q++;
                }
            }
        if(p>=m){
            return nums2[q];
        }else if(q>=n){
            return nums1[p];
        }else {
            return Math.min(nums1[p],nums2[q]);
        }
        }
    }


