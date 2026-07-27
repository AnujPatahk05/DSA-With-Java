public class _2_ArrayAsArgument {

    public static void addBonus(int marksArray[],int bonusMarks){
        for (int i = 0; i < marksArray.length; i++) {
            marksArray[i] += bonusMarks;            
        }
    }

    public static void printArrayElements(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1,6,2,3,4,5,1,3,6,8,6,4,2,44,222,3,4,0};
        

    }
}
