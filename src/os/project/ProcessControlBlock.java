package os.project;

public class ProcessControlBlock
{
	int p[];
	int memAddress, jobNum, jobSize, currentTime, priority, maxCpuTime;
	boolean isDoingIO, killBit, isBlocked; //kill bit used if job is to be terminated but still doing i/o
	
	ProcessControlBlock()
	{
		p = null;
		memAddress = -1;
		isDoingIO = false;
		killBit = false;
		isBlocked = false;
		this.jobNum = 0;
		this.jobSize = 0;
		this.currentTime = 0;
		this.priority = 0;
		this.maxCpuTime = 0;
	}
	
	ProcessControlBlock(int p[],int memAddress,int jobNum, int jobSize, int currentTime, int priority, int maxCpuTime)
	{
		p = null;
		memAddress = -1;
		isDoingIO = false;
		killBit = false;
		isBlocked = false;
		this.jobNum = jobNum;
		this.jobSize = jobSize;
		this.currentTime = currentTime;
		this.priority = priority;
		this.maxCpuTime = maxCpuTime;
	}
	
	boolean isBlocked()
	{
		return this.isBlocked;
	}
	
	void setBlocked(boolean isBlocked)
	{
		this.isBlocked = isBlocked;
	}
	
	boolean isDoingIO()
	{
		return isDoingIO;
	}
	
	void setDoingIO(boolean isDoingIO)
	{
		this.isDoingIO = isDoingIO;
	}
	
	int getMemLoc()
	{
		return memAddress;
	}
	
	void setMemLoc(int mAddress)
	{
		memAddress = mAddress;
	}
	
	int[] getP()
	{
		return p;
	}
	void setP(int incP[])
	{
		p = incP.clone();
	}
	
	void setJobNum(int jobNum)
	{
		this.jobNum = jobNum;
	}
	
	void setJobSize(int jobSize)
	{
		this.jobSize = jobSize;
	}
	
	void setCurrentTime(int currentTime)
	{
		this.currentTime = currentTime;
	}
	
	void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	void setMaxCpuTime(int maxCpuTime)
	{
		this.maxCpuTime = maxCpuTime;
	}
	
	int getJobNum()
	{
		return jobNum;
	}
	
	int getJobSize()
	{
		return jobSize;
	}
	
	int getCurrentTime()
	{
		return currentTime;
	}
	
	int getPriority()
	{
		return priority;
	}
	
	int getMaxCpuTime()
	{
		return maxCpuTime;
	}
	
}
