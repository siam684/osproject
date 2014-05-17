package os.project;


import java.util.LinkedList;
//import java.util.Iterator;
//import java.util.List;

public class OS 
{

	LinkedList<FreeSpaceNode> freeSpaceTable;
	LinkedList<ProcessControlBlock> jobTable;
	LinkedList<ProcessControlBlock> readyQueue;
	LinkedList<ProcessControlBlock> iOqueue;
	
	
	
	/*SOS calls this first
	 * initialize variables
	 * */
	void startup()
	{
		freeSpaceTable = new LinkedList<FreeSpaceNode>();
		freeSpaceTable.add(new FreeSpaceNode(0,99));
		jobTable = new LinkedList<ProcessControlBlock>(); //contains all info of jobs in system
		readyQueue = new LinkedList<ProcessControlBlock>();
		iOqueue = new LinkedList<ProcessControlBlock>();
	}
	
	
	/*
	 * idicates the arrival of new job on drum
	 * sos spooler sends new job to system
	 * p[1] = job number
	 * p[2] = priority 1.highest 5.lowest
	 * p[3] = job size
	 * p[4] = max cpu time allowed
	 * p[5] = current time
	 * */
	void Crint(int a[],int p[])
	{
		
		/* if there is a cpu that has cpu bookkeep
		 *  - if a[] = 2
		 *  	- save process that has cpu
		 *  		- save state to pcb
		 * else 
		 * call swapper to put jobs from job table to in memory
		 * 	- create new pcb with p[] data
		 *  - put new pcb in jobtable
		 *  - call swapper to look through job table to find a job to put into memory
		 *  
		 * add job to ready queue
		 * call dispatcher
		 * 
		 * */
		
		
		
		//call swapper to put job in memory
		//put job in ready queue, maybe do that in swapper?
		
		//before leaving any interrupt a[] p[] must be set
		//a* is state of cpu, 1= no jobs to run, cpu will wait until interrupt, ignore p values
		//a[] = 2, set cpu to run mode, must set p[] values
		/*
		 * p[0],p[1],p[5] are ignored
		 * p[2] = base addres of job to be run(mem address)
		 * p[3] = size
		 * p[4] = time quantom
		 * probably a call to the dispatcher
		 * */
		//leave each interrupt with return statement?
	}
	
	/*
	 * disk interrupt
	 * i/o transfer between disk and memory is complete
	 * p[5] = current time
	 * */
	void Dskint(int a[],int p[])
	{
		//before leaving any interrupt a[] p[] must be set
		//a* is state of cpu, 1= no jobs to run, cpu will wait until interrupt, ignore p values
		//a[] = 2, set cpu to run mode, must set p[] values
		/*
		 * p[0],p[1],p[5] are ignored
		 * p[2] = base addres of job to be run(mem address)
		 * p[3] = size
		 * p[4] = time quantom
		 * probably a call to the dispatcher
		 * */
		//leave each interrupt with return statement?
	}
	
	/*
	 * drum interrupt
	 * program transfer between drum and memory has completed swap
	 * p[5] = current time
	 * */
	void Drmint(int a[],int p[])
	{
		//before leaving any interrupt a[] p[] must be set
		//a* is state of cpu, 1= no jobs to run, cpu will wait until interrupt, ignore p values
		//a[] = 2, set cpu to run mode, must set p[] values
		/*
		 * p[0],p[1],p[5] are ignored
		 * p[2] = base addres of job to be run(mem address)
		 * p[3] = size
		 * p[4] = time quantom
		 * probably a call to the dispatcher
		 * */
		//leave each interrupt with return statement?
	}
	
	/*called by sos when intervalTimer reaches 0
	 * time run out
	 * timer interrupt
	 * p[5] = current time
	 * */
	void Tro(int a[],int p[])
	{
		//before leaving any interrupt a[] p[] must be set
		//a* is state of cpu, 1= no jobs to run, cpu will wait until interrupt, ignore p values
		//a[] = 2, set cpu to run mode, must set p[] values
		/*
		 * p[0],p[1],p[5] are ignored
		 * p[2] = base addres of job to be run(mem address)
		 * p[3] = size
		 * p[4] = time quantom
		 * probably a call to the dispatcher
		 * */
		//leave each interrupt with return statement?
	}
	
	
	/*
	 * supervisor call for user program
	 * invoked when the executing job needs service and has just executed a software interrupt instruction
	 * p[5] = current time
	 * a[] = 5 = job has terminated
	 * a[] = 6 = job request disk i/o
	 * a[] = 7 = job wants to be blocked until  i/o requests completed (prevented from running on cpu)
	 * 
	 * if job requests to be terminated it while doing i/o it must first finish i/o
	 * instead set kill bit
	 * 
	 * when job terminates it must be removed to jobtable and memory
	 * 
	 * when i/o is being done for a job it must be in core
	 * */
	void Svc(int a[],int p[])
	{
		//before leaving any interrupt a[] p[] must be set
		//a* is state of cpu, 1= no jobs to run, cpu will wait until interrupt, ignore p values
		//a[] = 2, set cpu to run mode, must set p[] values
		/*
		 * p[0],p[1],p[5] are ignored
		 * p[2] = base addres of job to be run(mem address)
		 * p[3] = size
		 * p[4] = time quantom
		 * probably a call to the dispatcher
		 * */
		//leave each interrupt with return statement?
	}

	/*
	 * 
	 * sets cpu registers before context switch
	 * must be called before leaving each interrupt
	 * should set a[] and p[] arguments
	 * a* =1 cpu idle
	 * a* =2 cpu in user ode
	 * p[0],p[1],p[5] are ignored
	 * p[2] = base addres of job to be run(mem address)
	 * p[3] = size
	 * p[4] = time quantom
	 * */
	void dispatch()
	{
		//if there are jobs
		//call scheduler to decided which job to pick
		//set p to the job values and a to 2 
		//only base address register(p[2]) and size register(p[3]) need to be set
		//else
		//halt cpu -- a[]=2;
		//leave each interrupt with return statement?
	}
	
	
	/*
	 * swaps jobs between drum and memory
	 * job currently doing i/o cant be swapped out of memory, use latch bit
	 * determine which job that is not in memory should be placed in memory
	 * long term scheduler
	 * calls routine to find space in memory
	 * handles drum interrupts?
	 * call siodrum to swap the job into memory
	 * may need to call swap jobs out to make room for the that you want to swap in
	 * 
	 * siodrum: start a drum transfer (swap)
	 * 		void siodrum(int jobnum,int jobsize, int startcoreaddress(mem),int transfer direction)
	 * 				direction:0= drum to mem, 1= mem to drum
	 * */
	void swap(int direction)
	{
		/*
		 * look through job table for job that is not in memory
		 * 	- check for state is new
		 * use memory manager to allocate memory
		 * 	- send job size
		 * 	-if space found			
		 * 		- put job in memory
		 * 		- save address in pcb
		 * 		- call siodrum with 0;
		 * 		
		 *  -else
		 *  	- 
		 * */
	}
}

