package os.project;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
public class MemoryManager
{
	LinkedList<FreeSpaceNode> freeSpaceTable;
	FreeSpaceNode tempNode;
	ListIterator<FreeSpaceNode> tableIterator;
	Boolean found = false;
	
	MemoryManager()
	{
		freeSpaceTable = new LinkedList<FreeSpaceNode>();
		freeSpaceTable.add(new FreeSpaceNode(0,100));
	}
	
	void allocate(int sizeOfJob)
	{
		//Collections.sort(freeSpaceTable);
		
		/*
		 * loop through each element to check for first free space that job can be placed
		 * until end of table. 
		 * */
		
		tableIterator = freeSpaceTable.listIterator();
		while(tableIterator.hasNext())
		{
			tempNode = tableIterator.next();
			
			/*
			 * if found, send size of job and index of node to memSplit
			 * to allocate memory and adjust free space table
			 * */
			
			if(tempNode.getSize()>sizeOfJob)
			{
				found = true;
				memSplit(sizeOfJob,freeSpaceTable.indexOf(tempNode));				
				break;
			}
			else
			{
				found = false;
			}
		}
		
		if(!found)
		{
			System.out.println("no space avaliable");
			//use algo to find witch job to swap out
			//call swapper to send job to drum from mem
		}
		
	}
	
	void free(int address, int size)
	{	
		freeSpaceTable.add(new FreeSpaceNode(address,size));
		Collections.sort(freeSpaceTable);
		memCoalesce(freeSpaceTable.size()-1);
	}
	
	void memCoalesce(int size)
	{
		if(size<=1)
		{
			return;
		}
		else
		{
			if(freeSpaceTable.get(size-1).getAddress()+freeSpaceTable.get(size-1).getSize()==freeSpaceTable.get(size).getAddress())
			{
				int sizeOfadjacent = freeSpaceTable.get(size).getSize();
				freeSpaceTable.remove(size);
				freeSpaceTable.get(size-1).setSize(sizeOfadjacent+freeSpaceTable.get(size-1).getSize());
				memCoalesce(size-1);
			}
		}			
		
		
	}
	
	void memSplit(int sizeOfJob, int index)
	{
		tempNode = freeSpaceTable.remove(index);
		
		freeSpaceTable.add(new FreeSpaceNode(tempNode.getAddress()+sizeOfJob,tempNode.getSize()-sizeOfJob));
		memCoalesce(freeSpaceTable.size()-1);		
	}
	
	void print()
	{
		tableIterator = freeSpaceTable.listIterator();
		while(tableIterator.hasNext())
		{
			//tempNode = ;
			System.out.println(" Address: "+ tableIterator.next().getAddress() + " Size: " + tableIterator.previous().getSize());
			tableIterator.next();
		}
	}
}
