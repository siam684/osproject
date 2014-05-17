package os.project;

import java.util.Scanner;
import java.util.LinkedList;
//import java.util.Iterator;
//import java.util.List;

public class OS 
{
	
	//LinkedList<ProcessControlBlock> jobTable;
	//MemoryManager mManage;
	
public static void main(String[] args)
	{
		MemoryManager mManage;
		mManage = new MemoryManager();
		
		Scanner in = new Scanner(System.in);
		int input2;
		int input3;
//		while(input!=0)
//		{
//			System.out.println("enter -1. free, -2.allocate");
//			input = in.nextInt();
//			
//			if(input==-2)
//			{
//				System.out.println("enter allocate size");
//				input2 = in.nextInt();
//				System.out.print(mManage.allocate(input2));
//			}
//			
//			if(input==-1)
//			{
//				System.out.println("enter free address");				
//				input2 = in.nextInt();
//				
//				System.out.println("enter free address");				
//				input3 = in.nextInt();
//				
//				mManage.free(input2,input3);
//				
//			}
//			System.out.println();
//			mManage.print();
//		}
		
		for(int x= 0;x<=8;x++)
		{
			System.out.print("Size:\t\t");
			input2 = in.nextInt();
			System.out.println("Address:\t"+ mManage.allocate(input2));
			System.out.println("Table: ");
			mManage.print();
			System.out.println("");	
		}
		
		for(int x= 0;x<=8;x++)
		{
			System.out.print("free address:\t");				
			input2 = in.nextInt();
			
			System.out.print("free size:\t");				
			input3 = in.nextInt();
			
			mManage.free(input2,input3);
			System.out.println("Table: ");
			mManage.print();
			System.out.println("");	
		}
		
		
		
		in.close();
	}
	
	
	/*SOS calles this first
	 * initialize variables
	 * */
	void startup()
	{
		//mManage = new MemoryManager();
		//jobTable = new LinkedList<ProcessControlBlock>(); //contains all info of jobs in system
	}
	
	
	/*
	 * idicates the arrival of new job on drum
	 * sos spooler sends new job to system
	 * p[1] = job number
	 * p[2] = priority
	 * p[3] = job size
	 * p[4] = max cpu time allowed
	 * p[5] = current time
	 * */
	void Crint(int a[],int p[])
	{
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
	 * a[] = 7 = job wants to be blocked until  i/o requests completed(prevented from running on cpu)
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
	
	void cpuSchedule()
	{
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
	 * */
	void swap()
	{
		
	}

}

/* 
 * siodisk: start disk transfer
 * 		void siodisk(int jobNum)
 * 
 * siodrum: start a drum transfer (swap)
 * 		void siodrum(int jobnum,int jobsize, int startcoreaddress(mem),int transfer direction)
 * 				direction:0= drum to mem, 1= mem to drum
 * 
 * 0. os sleeping
 * 1. iterrupt happens -  interrupts are disabled
 * 2. os keeps track of interrupted job (bookkeeping)
 * 3. os handles events signaled by interrupts (differs per interrupt)
 * 4. os schedules next job
 * 5. os dispatches job
 * 6. os sleeps
 * 
 * before return to os from each interrupt
 * 	- check if there is room in memory to swap in a new job from drum
 *  - check if jobs ready to run, if so schedule the job
 *  
 *  if a job has outstanding disk i/o requests and no requests are being serviced by disk(job in i/o queue) os can decided to leave 
 *  the job in meory or swap it out to drum but before os inituates an siodisk for any of the jobs i/o requests, the job must be in memory
 *  
 *  bookeeping: 
 *  	- when interrupt happens a running job will be terminated, it is the job of the os to make sure that information about the job that was
 *  	running is not lost
 *  	- must be done at the beginning of each interrupt handler
 *  	- os must schedule a job to run on the cpu before returning to sos
 *  
 * */
