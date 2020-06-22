import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;

public class AddressBook
{

	private ArrayList<Person> personArray;
	private int numberOfPerson = 0;
	public Scanner sc = new Scanner( System.in );

	public AddressBook()
        {
            personArray = new ArrayList<>();
	}

	public void readData()throws Exception
	{
		try
		{
			   FileInputStream fstream = new FileInputStream("Address_Book.txt");
    			DataInputStream in = new DataInputStream(fstream);
    			BufferedReader br = new BufferedReader(new InputStreamReader(in));
    			String data;
    			while ((data = br.readLine()) != null)
			   {
					String[] tmp = data.split("\t");    
					Person person = new Person( tmp[0], tmp[1], Long.parseLong(tmp[2]), tmp[3], tmp[4], Integer.parseInt(tmp[5]));
					personArray.add(person);
    			}
		}
		catch (Exception ex)
			{
				System.out.println("File not exist.");
			}
	}


	public Person getUserInput()
	{   String firstName,lastName,address,state;
            int pinCode;
            long phoneNumber;

            System.out.print("\n Enter Person First Name: ");
            firstName = sc.next();
            System.out.print("Enter Person Last Name: ");
            lastName = sc.next();
            System.out.print("Enter the Phone Number: ");
            phoneNumber = sc.nextLong();
            System.out.print("Enter Address: ");
            address = sc.next();
            System.out.print("Enter State: ");
            state = sc.next();
            System.out.print("Enter the Pincode: ");
            pinCode = sc.nextInt();
            Person person = new Person( firstName, lastName, phoneNumber, address, state, pinCode);
            return person;
	}

	public void getAddRecord()
        {
            Person person = getUserInput();
            personArray.add(person);
            numberOfPerson++;
	}

	public int getPersonIndex(String name)
        {
            int count = 0;
            while(count < personArray.size())
            {
                if((personArray.get(count).firstName).equals(name))
                    {
                        return count;
                    }
                count++;
            }
            return count;
	}

	public void getupdateRecord()
        {
            System.out.println("\n Enter person name you want to update: ");
            String name = sc.next();
            int count = 0;
            count = getPersonIndex(name);
            if (count < personArray.size())
            {
                personArray.get(count).readEntry();
                Person person = getUserInput();
                personArray.set(count, person);
                System.out.print( "\nFIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
                personArray.get(count).readEntry();
                return;
            }
            System.out.println("Required Contact Missing");
        }

	public void getViewAllRecord()
        {
			System.out.print( "\nFIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
            for (int i=0; i<personArray.size(); i++)
            {
                System.out.println();
                personArray.get(i).readEntry();
            }
	}

	public void getDeleteRecord()
        {
            System.out.println("\n Enter the first name of person you want to Delete: ");
            String name = sc.next();
            int count = 0;
            count = getPersonIndex(name);
            if (count < personArray.size())
            {
                personArray.remove(count);
                System.out.println("Person contact deleted");
			return;
            }
            System.out.println("Required Contact Missing");
	}

	public void sort(int sortBy)
        {
            for (int i = 0; i<personArray.size(); i++)
            {
                for (int j = 0; j<personArray.size(); j++)
				{
                    switch(sortBy)
                    {
                        case 1: if (personArray.get(i).firstName.compareToIgnoreCase(personArray.get(j).firstName)<0)
                                {
                                    Person temp = personArray.get(i);
                                    personArray.set(i, personArray.get(j));
                                    personArray.set(j, temp);
									System.out.print( "FIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
                                    personArray.get(i).readEntry();
                                    //personArray.get(j).readEntry();
                                }
								break;
                        case 2: if ( personArray.get(i).pinCode < personArray.get(j).pinCode)
                                {
                                    Person temp = personArray.get(i);
                                    personArray.set(i, personArray.get(j));
                                    personArray.set(j, temp);
 									System.out.print( "FIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
                                    personArray.get(i).readEntry();
                                    //personArray.get(j).readEntry();
                                }
								break;
                    }
				}
            }
        }

	public void getSortRecord()
	{
            System.out.println("\nEnter for sorting by Name or by PinCode :");
            int sortBy = 0;
            System.out.println(" 1)Name\n 2)Pincode");
            sortBy = sc.nextInt();
            sort(sortBy);
	}
        
        public void getSearchRecord() throws IOException 
        {
            String name;
            Scanner strInput = new Scanner(System.in);
            {
                System.out.println("\n Enter person name you want to search : ");
                name = strInput.nextLine();
                int count = 0;
                count = getPersonIndex(name);
                for (Person personArray1 : personArray)
                {
                    if (count < personArray.size())
                    {   
						System.out.print( "FIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
                        personArray.get(count).readEntry();
                        break;
                    }
                    System.out.println("\n Contact Missing");    
                }
            }
        }

	public void getSaveRecord() throws IOException
	{
            try (FileWriter writer = new FileWriter("Address_Book.txt")) 
            {
                for(int i=0; i<personArray.size(); i++)
                {
                    writer.write(personArray.get(i).writePerson()+System.lineSeparator());
                }
            }
            catch (Exception ex)
            {
                System.out.print("Something is wrong in saving.");
            }
	}
}
