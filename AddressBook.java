import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBook 
{
    public static void getAddRecord() throws IOException 
    {
        try (BufferedWriter bw = new BufferedWriter( new FileWriter("Address_Book.txt",true) ))
            {
                Scanner sc = new Scanner(System.in);
                String ID, name, age, addr;
                System.out.print("Enter the Employee ID: ");
                ID = sc.nextLine();
                System.out.print("Enter the Employee Name: ");
                name = sc.nextLine();
                System.out.print("Enter the Employee Age: ");
                age = sc.nextLine();
                System.out.print("Enter the Employee Address: ");
                addr = sc.nextLine();
                bw.write(ID+","+name+","+age+","+addr);
                bw.flush();
                bw.newLine();
            }
        catch(Exception e )
            {
                System.out.println("Incorrect added");
            }
    }
    
   public static void getViewAllRecord() throws IOException 
    {
        try (BufferedReader br = new BufferedReader( new FileReader("Address_Book.txt") )) 
        {
            String[] record = new String[50];
            System.out.println(" ------------------------------------------------------------- ");
            System.out.println("|	ID		Name 				Age			Address 		  |");
            System.out.println(" ------------------------------------------------------------- ");
            int i = 0; 
            while( (record[i] = br.readLine()) != null )
            {
                StringTokenizer st = new StringTokenizer(record[i],",");
                System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
                i++;
            }
            System.out.println("|	                                            	          |");
            System.out.println(" ------------------------------------------------------------- ");
        }
        catch ( Exception e )
        {
            System.out.println("Something is wrong");
        }
    }
    
    public static void getDeleteRecordByID() throws IOException
    {
        Scanner sc =  new Scanner(System.in);
    	String ID, record;
    	File tempDB = new File("Address_Book_temp.txt");
    	File db = new File("Address_Book.txt");
        BufferedWriter bw = null;
        try (BufferedReader br = new BufferedReader( new FileReader( db ))) 
        {
            bw = new BufferedWriter( new FileWriter( tempDB ) );
            System.out.println("\t\t Delete Employee Record\n");
            System.out.println("Enter the Employee ID: ");
            ID =  sc.nextLine();
            while( ( record = br.readLine() ) != null )
            {
                if( record.contains(ID) )
                    continue;
                bw.write(record);
                bw.flush();
                bw.newLine();
                
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in Delete");
        }
            bw.close();
            db.delete();
            tempDB.renameTo(db);
 
    }
    public static void getSearchRecordbyID() throws IOException 
    {
        String ID,record;
    	Scanner strInput = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader( new FileReader("Address_Book.txt") ))
        {
            System.out.println("\t\t Search Employee Record\n");
            System.out.println("Enter the Employee ID: ");
            ID = strInput.nextLine();
            System.out.println(" ------------------------------------------------------------- ");
            System.out.println("|	ID		Name 				Age			Address 		  |");
            System.out.println(" ------------------------------------------------------------- ");
            while( ( record = br.readLine() ) != null )
            {
                StringTokenizer st = new StringTokenizer(record,",");
                if( record.contains(ID) )
                {
                    System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
                }
            }
            System.out.println("|	                                            	          |");
            System.out.println(" ------------------------------------------------------------- ");
        }
        catch (Exception e )
        {
            System.out.println("Error in Searching ");
        }
    }
    
    public static void getupdateRecordbyID() throws IOException 
    {
        String newName, newAge, newAddr, record, ID = null,record2;
     // String name;
        File db = new File("Address_Book.txt");
        File tempDB = new File("Address_Book_temp.txt");
        BufferedWriter bw = null;
        Scanner strInput = null;
        try (BufferedReader br = new BufferedReader( new FileReader(db) ))
        {
            bw = new BufferedWriter( new FileWriter(tempDB) );
            strInput = new Scanner(System.in);
            System.out.println("\t\t Update Employee Record\n\n");
            System.out.println("Enter the Employee ID: ");
            ID = strInput.nextLine();
     //     name = strInput.nextLine();
            System.out.println(" ------------------------------------------------------------- ");
            System.out.println("|	ID		Name 				Age			Address 		  |");
            System.out.println(" ------------------------------------------------------------- ");
            while( ( record = br.readLine() ) != null )
            {
                StringTokenizer st = new StringTokenizer(record,",");
                if( record.contains(ID) )
                {
                    System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
                }
            }
            System.out.println("|	                                            	          |");
            System.out.println(" ------------------------------------------------------------- ");
        }
        catch (Exception e )
        {
            System.out.println("Id not found ");
        }
            
        System.out.println("Enter the new Name: ");
        newName = strInput.nextLine();    		
        System.out.println("Enter the new Age: ");
        newAge = strInput.nextLine();  
        System.out.println("Enter the new Address: ");
        newAddr = strInput.nextLine();  

        BufferedReader br2 = new BufferedReader( new FileReader(db) );
        while( (record2 = br2.readLine() ) != null ) 
        {    			
            if(record2.contains(ID))
            {
                bw.write(ID+","+newName+","+newAge+","+newAddr);
            }
            else
            {
                bw.write(record2);	
            }    			
            bw.flush();
            bw.newLine();
        }
        bw.close();
        br2.close();    		
        db.delete();    		
        boolean success = tempDB.renameTo(db);    		
        System.out.println(success);    		

    }
}
