import java.util.HashMap;
import java.util.Map;

public class OvertimeCount 
{

	
	
	public Map<String, Integer> getOvertimeStat()
	{
		Map<String, Integer>overtimeMap = new HashMap<>();
		overtimeMap.put("Admin", 75000);
		overtimeMap.put("Officer", 50000);
		overtimeMap.put("Supervisor", 25000);
		return overtimeMap;
	}

	public int OvertimeCountHours(String post) {
		Map<String, Integer> overtimeMap = null;
		int overtimePay = 0;
		
		if(post.isEmpty())
		{
			throw new NullPointerException("Input cannot be empty !!");
		}
		overtimeMap = getOvertimeStat();
		if(!overtimeMap.containsKey(post))
		{
			throw new NullPointerException("Invalid Input !!");
		}
		else
		{
			overtimePay = overtimeMap.get(post);
		}
	
		return overtimePay;
	}


}
