# 剑指offer 第十一题 
***
## 题目 
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
***
## 思路
二分搜索，注意考虑出现{1,1,0,1,1}这样的情况，这样只能通过顺序寻找的方式查找。