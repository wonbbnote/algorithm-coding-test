# 746. Min Cost Climbing Stairs

## Easy

***

You are given an integer array `cost` where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index `0`, or the step with index `1`.

Return _the minimum cost to reach the top of the floor_.

&#x20;

**Example 1:**

<pre><code><strong>Input: cost = [10,15,20]
</strong><strong>Output: 15
</strong><strong>Explanation: You will start at index 1.
</strong>- Pay 15 and climb two steps to reach the top.
The total cost is 15.
</code></pre>

**Example 2:**

<pre><code><strong>Input: cost = [1,100,1,1,1,100,1,1,100,1]
</strong><strong>Output: 6
</strong><strong>Explanation: You will start at index 0.
</strong>- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
</code></pre>

&#x20;

**Constraints:**

* `2 <= cost.length <= 1000`
* `0 <= cost[i] <= 999`
