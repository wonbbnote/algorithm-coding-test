# 1. Two Sum

## Easy

***

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have _**exactly**_**&#x20;one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [2,7,11,15], target = 9
</strong><strong>Output: [0,1]
</strong><strong>Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [3,2,4], target = 6
</strong><strong>Output: [1,2]
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: nums = [3,3], target = 6
</strong><strong>Output: [0,1]
</strong></code></pre>

&#x20;

**Constraints:**

* `2 <= nums.length <= 104`
* `-109 <= nums[i] <= 109`
* `-109 <= target <= 109`
* **Only one valid answer exists.**

&#x20;

**Follow-up:** Can you come up with an algorithm that is less than `O(n2)` time complexity?
