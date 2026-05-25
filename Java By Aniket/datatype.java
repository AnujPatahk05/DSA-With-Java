import java.util.Scanner;

public class datatype {
    
    public static void main (String[]args){
        System.out.println( "Hello word ");

        // int a=93876;
        // System.out.println(a);


        // boolean isVegetarian = true;
        // System.out.println(isVegetarian);


        // float b= 8.9f;
        // System.out.println(b);

        // double Mydouble=789.0;
        // System.out.println(Mydouble);





    //     // //****Unary operator****//
    //     int a = 99;

    //     // ***Additon***
    //     a++;
    //     System.out.println(a);

    //     ++a;
    //     System.out.println(a); 


    //    // ***Subtraction***
    //     a--;
    //     System.out.println(a);

    //     --a;
    //     System.out.println(--a);




    //**Arthemetic operator**//

 System.out.print("Enter first value :");
    Scanner input = new Scanner(System.in);
    int A = input.nextInt();

     System.out.print("Enter second value :");
     int B = input.nextInt();

   int sum = A + B ;
   System.out.println("sum of A and B is :" +sum );

 int minus = A - B ;
   System.out.println("minus of A and B is :" +minus );
   
   double divide = A / B ;
   System.out.println(" Division of A and B is :" +divide );

 int mul = A * B ;
   System.out.println("multipletion of A and B is :" +mul );
   

   int mudulus = A%B;
   System.out.println(" mudulus of A and B is:" + mudulus);


    }


}
