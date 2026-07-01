package project2;
import java.util.*;
public class ICICI_BANK {
	    static Scanner sc = new Scanner(System.in);

	    // Static Variables
	    static String bankName;
	    static String branch;
	    static String ifscCode;

	    // Non-static Variables
	    String name;
	    long mobileNumber;
	    String address;
	    double balance;
	    long accountNumber;

	    ICICI_BANK(String cName, long cMobileNumber, String cAddress, double cBalance)   // Parameterized Constructor
	    {
	        name = cName;
	        mobileNumber = cMobileNumber;
	        address = cAddress;
	        balance = cBalance;

	        generateAccountNumber();

	        System.out.println("Thanks For Trusting ICICI Bank!");
	    }

	    // Static Block
	    static
	    {
	        bankName = "ICICI";
	        branch = "Vadapalani";
	        ifscCode = "ICIC00016";
	    }

	    // Static Block
	    static
	    {
	        System.out.println("Welcome to " + bankName + " Bank");
	    }

	    // Non-static Method
	    public void generateAccountNumber()
	    {
	        Random r = new Random();
	        accountNumber = r.nextInt(10000, 99999);
	    }

	    public static void getBankDetails()
	    {
	        System.out.println("Bank Name : " + bankName);
	        System.out.println("Branch : " + branch);
	        System.out.println("IFSC Code : " + ifscCode);
	    }

	    public void getUserDetails()
	    {
	        System.out.println("Name : " + name);
	        System.out.println("Account Number : " + accountNumber);
	        System.out.println("Mobile Number : " + mobileNumber);
	        System.out.println("Balance : " + balance);
	    }

	    public static void main(String[] args)
	    {
	        System.out.println("Enter the Below Details :");

	        System.out.print("Name : ");
	        String name = sc.next();

	        System.out.print("Mobile Number : ");
	        long mobNum = sc.nextLong();

	        System.out.print("Address : ");
	        String add = sc.next();

	        System.out.print("Balance : ");
	        double bal = sc.nextDouble();

	        ICICI_BANK icici = new ICICI_BANK(name, mobNum, add, bal);

	        int choice = 0;
            do {
            System.out.println("1. Bank Details");
	        System.out.println("2. User Details");
            
	        System.out.print("Enter Your Choice : ");
	        choice = sc.nextInt();

	        if(choice == 1)
	        {
	            getBankDetails();
	        }
	        else if(choice == 2)
	        {
	            icici.getUserDetails();
	        }
            }while(choice !=3);
         int choice2 = 0;
	       do {
	    	System.out.println("1. Check Balance");
	        System.out.println("2. Withdraw Amount");
	        System.out.println("3. Deposit");

	        System.out.print("Enter Your Choice : ");
	        choice2 = sc.nextInt();

	        switch(choice2)
	        {
	        case 1:
            {
                System.out.println("Balance : " + icici.balance);
                break;
            }

            case 2:
            {
                System.out.print("Enter your Registered Mobile Number : ");
                long mobileNumber = sc.nextLong();

                if(icici.mobileNumber == mobileNumber)
                {
                    System.out.print("Enter Amount to Withdraw : ");
                    double amount = sc.nextDouble();

                    if(amount <= icici.balance)
                    {
                        icici.balance -= amount;

                        System.out.println(amount + " Withdraw Successfully");
                    }
                    else
                    {
                        System.out.println("Insufficient Balance.");
                    }
                }
                else
                {
                    System.out.println("Invalid Mobile Number");
                }

                break;
            }

            case 3:
            {
                System.out.print("Enter Amount to Deposit : ");

                double amount = sc.nextDouble();

                icici.balance += amount;

                System.out.println("Amount Deposited Successfully");

                break;
            }

            default:
            {
                System.out.println("Invalid Choice");
            }
        }
	       }while(choice2 !=4);
	    	    
}
}
