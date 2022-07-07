import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	int TotalSalary = 10000000;
	
	public Main() 
	{
		menu();
	}
	
	public void menu()
	{
		boolean running = true;
		
		do
		{
			System.out.println("---------------------------------------");
			System.out.println("Over Time and Attendance using TDD");
			System.out.println("---------------------------------------");
			System.out.println("Main Menu");
			System.out.println("---------------------------------------");
			System.out.println("1. Run the program");
			System.out.println("2. Exit");
			System.out.print("->  ");
			
			int pil = scan.nextInt();
			scan.nextLine();
			
			switch (pil)
			{
			case 1:
				MenuProgram();
				scan.nextLine();
				break;
			case 2:
				System.out.println("Thanks for using this app !!");
				scan.nextLine();
				running = !running;
				break;
			}
		}
		while(running);
	}
		
	public void MenuProgram()
	{
		System.out.println("---------------------------------------");
		System.out.println("Over Time and Attendance using TDD");
		System.out.println("---------------------------------------");
		System.out.println("Program...");
		System.out.println("---------------------------------------");
		System.out.println("1. Count Total Salary");
		System.out.println("2. Count Overtime");
		System.out.println("3. Count Penalty");
		System.out.println("4. Back To Main Menu");
		System.out.print("->  ");
		
		int pil = scan.nextInt();
		scan.nextLine();
		
		switch (pil)
		{
		case 1:
			CountTotalSalary();
			scan.nextLine();
			break;
		case 2:
			OverTime();
			scan.nextLine();
			break;
		case 3:
			 Attendance();
			scan.nextLine();
			break;
		case 4:
			menu();
			scan.nextLine();
			break;
		}
	}
	
	private void CountTotalSalary()
	{
		
		System.out.print("Input position late for work: ");
		String post = scan.nextLine();
		AttendanceCount attend = new AttendanceCount();
		int penaltyHour = attend.PenaltyCount(post);
		int PenHour = 0;
		do
		{
			System.out.print("Input Penalty hour [1-9] :");
			PenHour = scan.nextInt();
			scan.nextLine();
		}
		while (PenHour < 1 || PenHour > 9 );
		int penaltyfee = (penaltyHour * PenHour);

		OvertimeCount overtime = new OvertimeCount();
		int HourlyPay = overtime.OvertimeCountHours(post);
		int ovhour = 0;
		
		do
		{
			System.out.print("Input Overtime hour [1-10] :");
			ovhour = scan.nextInt();
			scan.nextLine();
		}
		while (ovhour < 1 || ovhour > 10 );
		
		int ovFee = (HourlyPay * ovhour);
		int allsal = (TotalSalary - penaltyfee + ovFee);
		System.out.println("---------------------------------------");
		System.out.println("YOUR SALARY");
		System.out.println("---------------------------------------");
		System.out.println("Total Overtime Pay: "+HourlyPay * ovhour);
		System.out.println("Total Penalty Fee: "+penaltyHour * PenHour);
		System.out.println("Total Salary After Overtime & Penalty :  "+allsal);
		
		System.out.println(" ");
		System.out.println("Press Any key to back to Menu");
		scan.nextLine();
		MenuProgram();
	}
	
	private void OverTime()
	{
		System.out.print("Input the position that will overtime ");
		String post = scan.nextLine();
		OvertimeCount overtime = new OvertimeCount();
		int HourlyPay = overtime.OvertimeCountHours(post);
		int ovhour = 0;
		
		do
		{
			System.out.print("Input hour [1-10] :");
			ovhour = scan.nextInt();
			scan.nextLine();
		}
		while (ovhour < 1 || ovhour > 10 );
		
		TotalSalary += (HourlyPay * ovhour);
		System.out.println("Total Overtime Pay: "+HourlyPay * ovhour);
		System.out.println("Total Salary after Overtime: "+TotalSalary);
		
		System.out.println(" ");
		System.out.println("Press Any key to back to Menu");
		scan.nextLine();
		MenuProgram();
	}
	
	private void Attendance()
	{
		System.out.print("Input position late for work: ");
		String post = scan.nextLine();
		AttendanceCount attend = new AttendanceCount();
		int penaltyHour = attend.PenaltyCount(post);
		int PenHour = 0;
		do
		{
			System.out.print("Input hour [1-9] :");
			PenHour = scan.nextInt();
			scan.nextLine();
		}
		while (PenHour < 1 || PenHour > 9 );
		TotalSalary -= (penaltyHour * PenHour);
		System.out.println("Total Overtime Pay: "+penaltyHour * PenHour);
		System.out.println("Total Salary after Overtime: "+TotalSalary);
		
		System.out.println(" ");
		System.out.println("Press Any key to back to Menu");
		scan.nextLine();
		MenuProgram();
	}

	public static void main(String[] args) 
	{
		new Main();
	}

}
