import org.junit.Assert;
import org.junit.Test;

public class AttendanceTest 
{

	public AttendanceTest() 
	{
		int overtimeHour  = 25000;  
		String post = "Admin";
		OvertimeCount overtime = new OvertimeCount();
		int count = overtime.OvertimeCountHours(post); 
		Assert.assertEquals(overtimeHour, count);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateOvertimeWithoutInput()
	{
		int overtimeHour  = 25000;  
		String post = "";
		OvertimeCount overtime = new OvertimeCount();
		int count = overtime.OvertimeCountHours(post);
		Assert.assertEquals(overtimeHour, count);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateOvertimeWithWrongInput()
	{
		int overtimeHour  = 25000;  
		String post = "QQZ";
		OvertimeCount overtime = new OvertimeCount();
		int count = overtime.OvertimeCountHours(post);
		Assert.assertEquals(overtimeHour, count);
	}

}
