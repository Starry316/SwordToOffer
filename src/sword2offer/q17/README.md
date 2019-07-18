# 剑指offer 第十五题 
***
## 题目 
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
***
## 思路
简单快速幂
如果求得了 base^n/2，那么base^n = base^n/2 * base^n/2
可以把时间复杂度优化到 logn
***
## 额外注意 
还需要考虑负数，为0等情况
***
## 衍生问题

