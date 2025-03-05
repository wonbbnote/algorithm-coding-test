# 1143. Longest Common Subsequence

## Medium

***

Given two strings `text1` and `text2`, return _the length of their longest **common subsequence**._ If there is no **common subsequence**, return `0`.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

* For example, `"ace"` is a subsequence of `"abcde"`.

A **common subsequence** of two strings is a subsequence that is common to both strings.

&#x20;

**Example 1:**

<pre><code><strong>Input: text1 = "abcde", text2 = "ace" 
</strong><strong>Output: 3  
</strong><strong>Explanation: The longest common subsequence is "ace" and its length is 3.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: text1 = "abc", text2 = "abc"
</strong><strong>Output: 3
</strong><strong>Explanation: The longest common subsequence is "abc" and its length is 3.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: text1 = "abc", text2 = "def"
</strong><strong>Output: 0
</strong><strong>Explanation: There is no such common subsequence, so the result is 0.
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= text1.length, text2.length <= 1000`
* `text1` and `text2` consist of only lowercase English characters.
