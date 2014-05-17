package os.project;

import java.util.LinkedList;
//import java.util.ListIterator;
import java.util.Collections;

public class CpuScheduler
{
	//private static ListIterator<ProcessControlBlock> queueIterator;
	
	public static int nextJob(LinkedList<ProcessControlBlock> readyQueue)
	{
		int index;
		Collections.sort(readyQueue);	
		index =  readyQueue.indexOf(readyQueue.getFirst());
		for(ProcessControlBlock e: readyQueue)
		{
			e.setPriority(e.getPriority()+1);
		}
		return index;
	}
	
	public void addtoQueue(ProcessControlBlock inProcess, LinkedList<ProcessControlBlock> readyQueue)
	{
		readyQueue.add(inProcess);		
		Collections.sort(readyQueue);
	}
	
	public static void removeFromQueue(ProcessControlBlock outProcess, LinkedList<ProcessControlBlock> readyQueue)
	{
		readyQueue.remove(readyQueue.indexOf(outProcess));
	}
	
	public static void removeFromQueue(LinkedList<ProcessControlBlock> readyQueue)
	{
		readyQueue.remove();
	}
}
