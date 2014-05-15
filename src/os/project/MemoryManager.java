package os.project;
import java.util.LinkedList;
import java.util.ListIterator;

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
	
	void free(int address)
	{
		tableIterator = freeSpaceTable.listIterator();
		while(tableIterator.hasNext())
		{
			if(tableIterator.next().getAddress()==address)
			{
				freeSpaceTable.remove(tableIterator.previousIndex());
			}
		}
	}
	
	void memCoalesce()
	{
		tableIterator = freeSpaceTable.listIterator();
		int indexOfnextNode, indexOfPreviousNode, indexOfCurentNode;
		while(tableIterator.hasNext())
		{
			tempNode = tableIterator.next();
			indexOfCurentNode = freeSpaceTable.indexOf(tempNode);
			if(tableIterator.hasNext())
			{
				indexOfnextNode = freeSpaceTable.indexOf(tempNode)+1;
				if(tempNode.getAddress()+tempNode.getSize()==freeSpaceTable.get(indexOfnextNode).getAddress())
				{
					freeSpaceTable.get(indexOfCurentNode).setSize(freeSpaceTable.get(indexOfnextNode).getSize()+
																  freeSpaceTable.get(indexOfCurentNode).getSize());
					freeSpaceTable.remove(indexOfnextNode);
				}				
			}
			
			if(tableIterator.hasPrevious())
			{
				indexOfPreviousNode = freeSpaceTable.indexOf(tempNode)-1;
				if(freeSpaceTable.get(indexOfPreviousNode+1).getAddress()+freeSpaceTable.get(indexOfPreviousNode+1).getSize()==tempNode.getAddress())
				{
					freeSpaceTable.get(indexOfPreviousNode).setSize(freeSpaceTable.get(indexOfPreviousNode).getSize()+
							  									  freeSpaceTable.get(indexOfCurentNode).getSize());
					freeSpaceTable.remove(indexOfCurentNode);
				}
			}
		}
	}
	
	void memSplit(int sizeOfJob, int index)
	{
		tempNode = freeSpaceTable.remove(index);
		
		freeSpaceTable.add(new FreeSpaceNode(tempNode.getAddress()+sizeOfJob,tempNode.getSize()-sizeOfJob));
		memCoalesce();		
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
