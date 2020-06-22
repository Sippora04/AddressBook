public class Person
{
    public String firstName;
    public String lastName;
    public String address;
    public String state;
    public int pinCode;
    public long phoneNumber;

    public Person(String firstName, String lastName, long phoneNumber, String address, String state, int pinCode)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.state = state;
        this.pinCode = pinCode;
    }
    public void readEntry()
    {
        System.out.print( firstName + "\t\t" + lastName + "\t\t" + phoneNumber + "\t\t" + address + "\t\t" + state + "\t\t" + pinCode );
    }


  public String writePerson()
    {
        System.out.print( "FIRSTNAME\tLASTNAME\tPHONE_NUMBER\tADDRESS\t\tSTATE\t\tPINCODE\n" );
        String str = firstName+"\t\t"+lastName+"\t\t"+phoneNumber+"\t\t"+address+"\t\t"+state+"\t\t"+pinCode;
        return str;
    }

    public void main(String[] args)
    {
        System.out.println("Welcome to Address Book");
	Person person = new Person("Sippora ", "Toppo ", 928428429 , "Hno1333 ","Delhi ", 239012 );
	readEntry();
	System.out.println(person.writePerson());
    }
}
