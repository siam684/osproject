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
		freeSpaceTable.add(new FreeSpaceNode(0,99));
	}
	
	int allocate(int sizeOfJob)
	{
		/*
		 * loop through each element to check for first free space that job can be placed
		 * until end of table. 
		 * */
		int address= -2;
		tableIterator = freeSpaceTable.listIterator();
		while(tableIterator.hasNext())
		{
			tempNode = tableIterator.next();
			
			/*
			 * if found, send size of job and index of node to memSplit
			 * to allocate memory and adjust free space table
			 * */
			if(tempNode.getSize()>=sizeOfJob)
			{
				found = true;
				Collections.sort(freeSpaceTable);
				address =  memSplit(sizeOfJob,freeSpaceTable.indexOf(tempNode));
			}
			else
			{
				System.out.println("no space avaliable");
				address = -1;
			}
		}
		return address;
		
	}
	
	void free(int address, int size)
	{	
		freeSpaceTable.add(new FreeSpaceNode(address,size));
		Collections.sort(freeSpaceTable);
		memCoalesce();
	}
	
	void memCoalesce()
	{
		int size = freeSpaceTable.size()-1;
		while((size>0))
		{
			if(freeSpaceTable.get(size-1).getAddress()+freeSpaceTable.get(size-1).getSize()==freeSpaceTable.get(size).getAddress())
			{
				int sizeOfadjacent = freeSpaceTable.get(size).getSize();
				freeSpaceTable.remove(size);
				freeSpaceTable.get(size-1).setSize(sizeOfadjacent+freeSpaceTable.get(size-1).getSize());
			}
			size--;
		}
	}
	
	int memSplit(int sizeOfJob, int index)
	{
		tempNode = freeSpaceTable.remove(index);		
		freeSpaceTable.add(new FreeSpaceNode(tempNode.getAddress()+sizeOfJob,tempNode.getSize()-sizeOfJob));
		return tempNode.getAddress();
	}
	
	void print()
	{
		tableIterator = freeSpaceTable.listIterator();
		while(tableIterator.hasNext())
		{
			System.out.println("Address: "+ tableIterator.next().getAddress() + " Size: " + tableIterator.previous().getSize());
			tableIterator.next();
		}
	}
}
