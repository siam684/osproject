package os.project;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;

public class OS 
{
	public static void main(String[] args)
	{
		MemoryManager mManage;
		mManage = new MemoryManager();
		mManage.print();
		mManage.allocate(60);		
		mManage.print();
		mManage.allocate(100);
		mManage.print();
		mManage.allocate(20);
		mManage.free(0);
		mManage.print();
		mManage.free(80);
		mManage.print();
	}
	
	void startup()
	{
		//mManage = new MemoryManager();
	}
	
	void Crint(int a[],int p[])
	{
		
	}
	
	void Dskint(int a[],int p[])
	{
		
	}
	
	void Drmint(int a[],int p[])
	{
		
	}
	
	void Tro(int a[],int p[])
	{
		
	}
	
	void Svc(int a[],int p[])
	{
		
	}
	
	void cpuSchedule()
	{
		
	}
	
	void dispatch()
	{
		
	}
	
	
	/*
	 * swaps jobs between drum and memory
	 * */
	void swap()
	{
		
	}


	
	
	
}
