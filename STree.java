import java.lang.annotation.Retention;

public class STree {



    static int tree[];
    public static void init(int n ) {
        tree = new int [4*n];
        
    }
    // public static int buildTree(int arr[], int sti, int start, int end) {
    //     if(start == end) {
    //         tree[sti] = arr[start];
    //         return arr[start];
    //     }
    //     int mid = start +(end-start)/2;
    //     int leftTree = buildTree(arr, 2*sti+1, start, mid);
    //     int rightTree = buildTree(arr, 2*sti+2, mid+1, end);
    //     return tree[sti] =leftTree + rightTree;

    // }
    public static void print() {
        for(int i=0; i<tree.length; i++) {
            if(tree[i] ==0) {
                break;
            }
            System.out.print(tree[i] + " ");
        }
    }

  
    public static int buildTreeMaxElement(int arr[], int sti, int start, int end) {
        if(start == end) {
            tree[sti] = arr[start];
            return arr[start];
        }
        int mid = start +(end-start)/2;
        int leftTree = buildTreeMaxElement(arr, 2*sti+1, start, mid);
        int rightTree = buildTreeMaxElement(arr, 2*sti+2, mid+1, end);
        return tree[sti] =Math.max(leftTree, rightTree);

    }      
    // query
    public static int getMaxElement(int arr[]) {
     int si =0;
     int sj = arr.length-1;
     return getMaxElementUtil(3, 6,si , sj, 0);
     

    }
public static int getMaxElementUtil(int qi, int qj, int si, int sj, int i) {
    if(qi > sj || si >qj) {   // non overlapping
        return Integer.MIN_VALUE;
    }
  else   if(qi <= si && qj>= sj) {
        return tree[i];
    }
    else{
    int mid = (si+sj)/2;
    int leftTree = getMaxElementUtil(qi, qj, si, mid, 2*i+1);
    int rightTree = getMaxElementUtil(qi, qj, mid+1, sj, 2*i+2);
    return Math.max(leftTree, rightTree);
}
}

public static void update(int arr[], int idx, int newVal) {
    int si =0;
    int sj = arr.length-1;
    arr[idx] = newVal;

}
public static int updateUtil(int si, int sj, int idx, int i ) {
    if(idx <si || idx >sj) {
return tree[i];
    }
}
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        // buildTree(arr, 0, 0, n-1);
        buildTreeMaxElement(arr, 0, 0, n-1);
        // print();
        // System.out.println();
       System.out.println(getMaxElement(arr));
        // print();
        // System.out.println(tree[0]);
    }
}
