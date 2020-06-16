import java.io.*;
import java.util.*;

public class AddressBookManager
{ 
    public static void main(String[] args) throws IOException
    {   
        AddressBook addressbook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 'y' to continue with the AddressBook " );
        String choice = "y";        
        String ch = sc.nextLine();
        while( choice.equals(ch) )
        {        	
            System.out.println("1 ===> Add New Record ");
            System.out.println("2 ===> View All Record ");	
            System.out.println("3 ===> Delete Record ");
            System.out.println("4 ===> Search Record ");
            System.out.println("5 ===> Update Record ");	        
	    
            System.out.println("\n Enter your choice: ");
            choice = sc.nextLine();
            switch(choice)
            {
                case "1": AddressBook.getAddRecord();
                        break;
                case "2": AddressBook.getViewAllRecord();
                        break;
                case "3": AddressBook.getDeleteRecordByID();
                        break;
                case "4": AddressBook.getSearchRecordbyID();
                        break;
                case "5": AddressBook.getupdateRecordbyID();
                        break;
            }
            System.out.println("Do you want to continue? 'y/n'");
            choice = sc.nextLine();
        }
    }
}

/*
$ java AddressBookManager

Enter 'y' to continue with the AddressBook
y
1 ===> Add New Record
2 ===> View All Record
3 ===> Delete Record
4 ===> Search Record
5 ===> Update Record

 Enter your choice:
1
Enter the Employee ID: 101
Enter the Employee Name: Sippora
Enter the Employee Age: 12
Enter the Employee Address: Delhi
Do you want to continue? 'y/n'
y
1 ===> Add New Record
2 ===> View All Record
3 ===> Delete Record
4 ===> Search Record
5 ===> Update Record

 Enter your choice:
5
                 Update Employee Record


Enter the Employee ID:
101
 -------------------------------------------------------------
|       ID              Name                            Age                     Address                   |
 -------------------------------------------------------------
|       101     Sippora                 12                      Delhi      |
|                                                                 |
 -------------------------------------------------------------
Enter the new Name:
Sippora Toppo
Enter the new Age:
12
Enter the new Address:
New Delhi
true
Do you want to continue? 'y/n'
y
1 ===> Add New Record
2 ===> View All Record
3 ===> Delete Record
4 ===> Search Record
5 ===> Update Record

 Enter your choice:
4
                 Search Employee Record

Enter the Employee ID:
101
 -------------------------------------------------------------
|       ID              Name                            Age                     Address                   |
 -------------------------------------------------------------
|       101     Sippora Toppo           12                      New Delhi      |
|                                                                 |
 -------------------------------------------------------------
Do you want to continue? 'y/n'
n
*/
