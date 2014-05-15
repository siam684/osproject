package os.project;
import java.util.LinkedList;

public class OS 
{
	
	LinkedList<FreeSpaceNode> freeSpaceTable;
	FreeSpaceNode outNode;
	
	void startup()
	{
		freeSpaceTable = new LinkedList<FreeSpaceNode>();
		freeSpaceTable.add(new FreeSpaceNode(0,100));
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
	
	/*
	 * 
	 * */
	void memManage(int sizeOfJob)
	{
		int sentinal = 1;
		/*
		 * loop through each element to check for first free space that job can be placed
		 * until end of table. 
		 * */
		while(freeSpaceTable.peek().getSize()<sizeOfJob&&sentinal<=freeSpaceTable.size())
		{
			freeSpaceTable.push(freeSpaceTable.pop());
			sentinal++;
		}
				
		if(sentinal<freeSpaceTable.size())
		{
			/*split memory block giving the job memory
			 * and placing the rest back into the table
			 **/
			memSplit(sizeOfJob);
		}
		else
		{
			//choose algorithm to replace job
			//call to swapper to swap job drum->mem 
		}
		
		memCoalesce();
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

	void memCoalesce()
	{
		
	}
	
	void memSplit(int sizeOfJob)
	{
		outNode = freeSpaceTable.remove();
		freeSpaceTable.add(new FreeSpaceNode(outNode.getAddress()+sizeOfJob,outNode.getSize()-sizeOfJob));
	}
	
}
