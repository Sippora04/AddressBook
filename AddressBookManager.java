import java.io.*;
import java.util.*;

public class AddressBookManager
{ 
    public static void main(String[] args) throws IOException, Exception
    {   
        AddressBook addressbook = new AddressBook();
        addressbook.readData();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n\t\t Welcome to Address Book");
        int check = 1;
        while( check != 0 )
        {        	
            System.out.println("1 ===> Add Record ");
            System.out.println("2 ===> View Record ");	
            System.out.println("3 ===> Delete Record ");
            System.out.println("4 ===> Search Record ");
            System.out.println("5 ===> Update Record ");
            System.out.println("6 ===> Sort Record ");
            System.out.println("7 ===> Save Record");
	    
            System.out.println("\n Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: addressbook.getAddRecord();
                          break;
                case 2: addressbook.getViewAllRecord();
                          break;
                case 3: addressbook.getDeleteRecord();
                          break;
                case 4: addressbook.getSearchRecord();
                          break;
                case 5: addressbook.getupdateRecord();
                          break;
                case 6: addressbook.getSortRecord();
                          break;
                case 7: addressbook.getSaveRecord();
                          break;

                default: System.exit(0);
            }
            System.out.println("\n\t\t Do you want to continue? 'Press 1' or  for exit 'Press 0' ");
            check = sc.nextInt();
        }
    }
}


