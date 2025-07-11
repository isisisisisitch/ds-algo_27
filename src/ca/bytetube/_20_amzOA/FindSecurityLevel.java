package ca.bytetube._20_amzOA;

import java.util.HashMap;
import java.util.Map;

public class FindSecurityLevel {
    public static void main(String[] args) {
        System.out.println(findSecurityLevel(new int[]{1,3,2,4},4));
    }

    /*
      思路：
      preSum[i] 计算pid[0]~pid[i-1]的和
      对于每个右端r,遍历所有的左端l,子数组pid[l..r]的和为 preSum[r-1] - preSum[l];
      (preSum[r+1] - preSum[l])% k = (r- l + 1);
      等价于 preSum[r+1] % k - preSum[l]% k = (r -l + 1)%k;
      preSum[l]%k = (preSum[r+1]%k - (r -l + 1)%k + k ) % k;
       求出(preSum[a]%k,a)出现的次数
     */
    public static int findSecurityLevel(int[] pid, int k) {
        int n = pid.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + pid[i];
        }
        int res = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        //preSum为0，下标为0的情况出现1次
        map.computeIfAbsent(0, z -> new HashMap<>()).put(0, 1);

        for (int r = 0; r < n; r++) {
            int modSum = preSum[r + 1] % k;//当前preSum对k取模运算
            for (int l = 0; l <= r; l++) {
                int len = r - l + 1;//子数组的长度
                int need = (modSum - len % k + k) % k;
                int idxMod = l % k;
                if (map.containsKey(need) && map.get(need).containsKey(idxMod)) {
                    res += map.get(need).get(idxMod);
                }
            }

            int idxMod = (r + 1) % k;
            map.computeIfAbsent(modSum, z -> new HashMap<>()).put(idxMod, map.get(modSum).getOrDefault(idxMod, 0) + 1);
        }


        return res;
    }

}
