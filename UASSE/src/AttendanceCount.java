import java.util.HashMap;
import java.util.Map;

public class AttendanceCount 
{

	public Map<String, Integer> getPenaltyStat()
	{
		Map<String, Integer>AttendanceMap = new HashMap<>();
		AttendanceMap.put("Admin", 25000);
		AttendanceMap.put("Officer", 50000);
		AttendanceMap.put("Supervisor", 75000);
		return AttendanceMap;
	}
	
	public int PenaltyCount(String post) 
	{
		Map<String, Integer> AttendanceMap = null;
		int PenaltyFee = 0;
		
		if(post.isEmpty())
		{
			throw new NullPointerException("Input cannot be empty !!");
		}
		AttendanceMap = getPenaltyStat();
		if(!AttendanceMap.containsKey(post))
		{
			throw new NullPointerException("Invalid Input !!");
		}
		else
		{
			PenaltyFee = AttendanceMap.get(post);
		}
		return PenaltyFee;	
	}
}

	

	