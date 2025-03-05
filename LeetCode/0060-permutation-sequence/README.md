# 60. Permutation Sequence

## Hard

***

The set `[1, 2, 3, ..., n]` contains a total of `n!` unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for `n = 3`:

1. `"123"`
2. `"132"`
3. `"213"`
4. `"231"`
5. `"312"`
6. `"321"`

Given `n` and `k`, return the `kth` permutation sequence.

&#x20;

**Example 1:**

<pre><code><strong>Input: n = 3, k = 3
</strong><strong>Output: "213"
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: n = 4, k = 9
</strong><strong>Output: "2314"
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: n = 3, k = 1
</strong><strong>Output: "123"
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= n <= 9`
* `1 <= k <= n!`
