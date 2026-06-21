

public class _3_SearchInSortedRotatedArray {
    public static int Search(int[] arr,int target,int si,int ei){
        if(si > ei)return -1;
        
        int mid = si + (ei-si)/2;
        if(arr[mid] == target){
            return mid;
        }

        //L1
        if(arr[si] <= arr[mid]){
            if(target >= arr[si] && target < arr[mid]){
                return Search(arr, target, si, mid-1);
            }else{
                return Search(arr, target, mid+1, ei);
            }
        }

        //L2
        else{
            if(target > arr[mid] && target <= arr[ei]){
                return Search(arr, target, mid+1, ei);
            }else{
                return Search(arr, target, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,7,8,9,1,2,3,4,5};
        System.out.println(Search(arr, 11, 0, arr.length-1));//11
        System.out.println(Search(arr, 4, 0, arr.length-1));//3
        System.out.println(Search(arr, 0, 0, arr.length-1));//9
        System.out.println(Search(arr, 13, 0, arr.length-1));//-1


        
    }
}
