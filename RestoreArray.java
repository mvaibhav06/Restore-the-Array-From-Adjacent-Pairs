import java.util.Arrays;
import java.util.HashMap;

public class RestoreArray {
    public static int[] restoreArray(int[][] pairs){
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i=0; i<pairs.length; i++){
            if (temp.containsKey(pairs[i][0])){
                temp.put(pairs[i][0], temp.get(pairs[i][0])+1);
            }else {
                temp.put(pairs[i][0],1);
            }
            if (temp.containsKey(pairs[i][1])){
                temp.put(pairs[i][1], temp.get(pairs[i][1])+1);
            }else {
                temp.put(pairs[i][1],1);
            }
        }
        int[] out = new int[pairs.length+1];
        int p = 0;
        int i=0;

        while (p < out.length){
            if (p==0 && temp.get(pairs[i][0]) == 1){
                out[p] = pairs[i][0];
                p++;
                out[p] = pairs[i][1];
                p++;
                i++;
                if (i == pairs.length){
                    i = 0;
                }
                continue;
            }
            if (p==0 && temp.get(pairs[i][1]) == 1){
                out[p] = pairs[i][1];
                p++;
                out[p] = pairs[i][0];
                p++;
                i++;
                if (i == pairs.length){
                    i = 0;
                }
                continue;
            }
            if (p>0 && out[p-1]==pairs[i][0]){

                out[p] = pairs[i][1];
                p++;
                i++;
                if (i == pairs.length){
                    i = 0;
                }
                continue;
            }
            if (p>0 && out[p-1]==pairs[i][1]){

                out[p] = pairs[i][0];
                p++;
                i++;
                if (i == pairs.length){
                    i = 0;
                }
                continue;
            }
            i++;
            if (i == pairs.length){
                i = 0;
            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[][] pairs = {{-3,-9},{-5,3},{2,-9},{6,-3},{6,1},{5,3},{8,5},{-5,1},{7,2}};
        System.out.println(Arrays.toString(restoreArray(pairs)));
    }
}
