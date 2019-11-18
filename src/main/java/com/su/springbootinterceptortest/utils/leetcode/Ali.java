package com.su.springbootinterceptortest.utils.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ali {



    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;


    }

    public int[] twoSum2(int[] nums, int target) {
        int result[] = new int[2];

        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else
                map.put(target - nums[i], i);
        }

        return null;
    }


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if(s == null || s.length() == 0)
            return 0;
        List<String> noRepeat = new LinkedList<String>();
        int max = 0;
        for(int i = 0; i < chars.length; i++) {
            if(!noRepeat.contains(String.valueOf(chars[i]))) {
                noRepeat.add(String.valueOf(chars[i]));
            } else {
                if(noRepeat.size() > max)
                    max = noRepeat.size();



                noRepeat = noRepeat.subList(noRepeat.indexOf(String.valueOf(chars[i])) + 1, noRepeat.size());
                noRepeat.add(String.valueOf(chars[i]));

            }

            if(noRepeat.size() > max)
                max = noRepeat.size();
        }

        return max;

    }

    public int length(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int max = 0;
        for(int i = 0; i < chars.length; i++) {
            for(int j = start; j < i; j++) {
                if(chars[i] == chars[j]) {

                    start = j + 1;
                    break;

                }
            }

            if(i - start + 1 > max) {
                max = i - start+ 1;
            }
        }

        return max;
    }


    /**
     * 最长回文串 a
     * 动态规划  status[i][j] = status[i+1][j-1] && a[i]==a[j]
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] status = new boolean[s.length()][s.length()];
        String max = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                status[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || status[i+1][j-1]) ;
                if(status[i][j] && j - i + 1 > max.length())
                    max = s.substring(i, j+1);
            }
        }

        return max;
    }



    public String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        boolean[][] status = new boolean[s.length()][s.length()];
        String max = "";
        for(int i = chars.length - 1; i >= 0; i++) {
            for(int j = i; j < chars.length; j++) {
                status[i][j] = chars[i] == chars[j] && (status[i+1][j-1] || j - i < 3);
                if(status[i][j] && j - i + 1 > max.length())
                    max = s.substring(i, j+1);
            }
        }

        return max;
    }


    /**
     * 求平方根，精确到小数点后六位
     * @param value
     */
    public double getSquare(double value) {

        double low = 0;
        double high = value;
        double middle;
        while(low <= high) {
            middle = (high + low) / 2.000;
            if(Math.abs(Math.pow(middle, 2) - value) <= Double.valueOf(0.000001))
                return middle;
            else if(Math.pow(middle, 2) > value) {
                high = middle;
            }else
                low = middle;
        }

        return -1;
    }


    /**
     * 二分查找变种： 循环有序数组
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int nums[], int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int mid = (last - first) / 2 + first;
            if (nums[mid] == target)
                return mid;
            else if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            }
            else {
                if (nums[mid] < target && target <= nums[last])
                    first = mid + 1;
                else
                    last = mid - 1;
            }
        }
        return -1;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 两数相加
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = new ListNode(0);
        ListNode head = p;
        int next = 0;

        while(l1 != null || l2 != null || next > 0) {
            int val1 = l1 == null ? 0: l1.val;
            int val2 = l2 == null ? 0: l2.val;
            int val = (val1 + val2 + next) % 10;

            ListNode node = new ListNode(val);
            p.next = node;
            p = p.next;
            next = (val1 + val2 + next) / 10;

            l1 = l1 == null ? null:l1.next;
            l2 = l2 == null ? null:l2.next;
        }

        return head.next;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = head.next;
        while(p != null) {
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }

        return head;
    }

    public int reverse(int x) {

        long result = 0;
        while(x != 0) {
            result = result * 10 +  x % 10;
            x = x / 10;
        }

        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)? 0: (int)result;
    }


    public static void main(String args[]) {
        Ali ali = new Ali();
        System.out.println(ali.reverse(123));
    }


}











