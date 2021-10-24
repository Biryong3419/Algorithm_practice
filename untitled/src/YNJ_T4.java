public class YNJ_T4 {
}
class Solution1515 {
    public int solution(String L1, String L2) {
        // write your code in Java SE 8
        long startTime = System.currentTimeMillis();
        int max = 0;
        for(int i = 0; i < L1.length(); i ++) {
            int tmpMax = 0;
            //test1
            int a = L1.substring(0, i).replaceAll("\\.", "").length();
            int b = L2.substring(i+1, L1.length()).replaceAll("\\.", "").length();


            //test2
            int c = L1.substring(i+1, L1.length()).replaceAll("\\.", "").length();
            int d = L2.substring(0, i).replaceAll("\\.", "").length();

            if(a+b > c+d) {
                tmpMax = a+b;
            }else {
                tmpMax = c+d;
            }

            if(max < tmpMax) {
                max = tmpMax;
            }
        }

        int l1max = L1.replaceAll("\\.", "").length();
        if(l1max > max) {
            max = l1max;
        }

        int l2max = L2.replaceAll("\\.", "").length();
        if(l2max > max) {
            max = l2max;
        }

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println(estimatedTime);
        System.out.println(max);

        return max;
    }

    public static void main(String[] args) {
        Solution1515 s = new Solution1515();
        s.solution(".xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x.xxx...x",
                "..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx..x.xxxx");
    }
}
