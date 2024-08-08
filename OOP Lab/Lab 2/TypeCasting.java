public class TypeCasting {
    public static void main(String[] args) {
        int x =10;	
        double y = x;
        System.out.println(y);	    

        double x1 = 10.5;
        int y1 = x1;	
        System.out.println(y1); 
        //Compilation error verified, typecasting needed to convert double to inr. else type mismatch errror
    
        double x2=10.5;	     
        int y2 = (int) x2;  
        System.out.println(y2);	                    



    }
}
