import java.util.Scanner;
class Book{
    String  title;
    String author;
    int edition;
    Book(String title,String auth,int edit )
    {
        this.title=title;
        this.author=auth;
        this.edition=edit;
    }
    void display()
    {
        System.out.println("Title:"+title);
        System.out.println("Author:"+author);
        System.out.println("Edition:"+edition+"\n");
    }
}

class bookmain
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        String  title;
        String author;
        int edition,i;        
        Book arr[]=new Book[6];           
        for(i = 0; i < 6; i++)              
        {
            System.out.println("Enter the details of book "+(i+1));
            System.out.println("Enter the title:");
            title=in.nextLine();
            System.out.println("Enter the author");
            author=in.nextLine();
            System.out.println("Enter the edition number:");
            edition=in.nextInt();
            in.nextLine();
            arr[i]=new Book(title,author,edition);           
        }
        System.out.println("Which authors book do you want to see?");
        String autho=in.nextLine();
        for(i=0;i<6;i++)    
        {
            if (arr[i].author.equals(autho)){
                arr[i].display();
            }

        }  
        in.close();
    }
}
//ascending order not clear based on which parameter
