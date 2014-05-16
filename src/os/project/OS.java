package os.project;

//import java.util.Iterator;
//import java.util.List;

public class OS 
{
	public static void main(String[] args)
	{
		MemoryManager mManage;
		mManage = new MemoryManager();
		mManage.allocate(60);
		mManage.allocate(20);
		mManage.allocate(10);
		
		System.out.println();
		mManage.print();
		mManage.free(60,20);
		
		System.out.println();
		mManage.print();
		
		mManage.free(80,10);
		System.out.println();
		mManage.print();
		
		
		mManage.free(40, 20);
		System.out.println();
		mManage.print();
		
		mManage.free(0, 40);
		System.out.println();
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
