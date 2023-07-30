import java.util.HashMap;
import java.util.Map;

public class _1_1_SumOfTwoNum {
//    时间复杂度：O（N^2),空间复杂度O（1）
//    我最初的写法
//    public static int[] twoSum(int[] nums, int target) {
//        // 输入数组和目标值，遍历数组，将数组中的任两数之和=target的下标列出
//        int[] index = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    index[0] = i;
//                    index[1] = j;
//                }
//            }
//        }
//        return index;
//    }

////    另一种：但是运行用时更长了，内存占用还是和上面一样。所以应该提前声明int数组吗
//        public static int[] twoSum(int[] nums, int target) {
//        // 输入数组和目标值，遍历数组，将数组中的任两数之和=target的下标列出
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];
//    }

//    用哈希表算法来优化：时间复杂度O(N)，空间复杂度O(N)
//    时间复杂度较高的原因是，每次都要寻找x对应的target-x，而且每次都是重新查找数组中的所有元素。
//    所以现在使用查找表来记录已经遍历过的元素的信息，后面x遇到对应的target-x后，就可以快速根据索引取出元素
//    查找表有两种常见的使用方式，平衡二叉搜索树，哈希表
//    因为不需要保证已经遍历过的数据的顺序，所以选用哈希表
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
//        因为nums[0]前面没有已遍历的元素，也就找不到对应的target-x元素，所以直接加入到哈希表中
        map.put(nums[0],0);
        for (int i=1;i<nums.length;i++){
            int another = target-nums[i];
//            如果哈希表中含有target-x元素，则直接取出，没有就将nums[i]放入map
            if(map.containsKey(another)){
                return new int[]{i,map.get(another)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 4;
        for (int i :
                twoSum(nums, target)) {
            System.out.println(i);
        }
    }

}
