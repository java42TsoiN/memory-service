package telran.util.memory;

public class MemoryService {
	public static int getMaxAvailableMemory() {
		long maxMemory = Runtime.getRuntime().maxMemory();
		int maxSize = maxMemory>Integer.MAX_VALUE? Integer.MAX_VALUE:(int) maxMemory;
		int start = 0, end = maxSize;
		byte ar[];
		int i = 0;
	    boolean allocated;
		do {
	         int middle = (int) ((start +  end) / 2); 
	         allocated = false;
	         try {
	        	ar = new byte[middle];
	        	ar = null;
	            allocated = true;
	         }
	         catch (java.lang.OutOfMemoryError e) {
	        	 ar = null;
	        	 return i;
	         } 

	         System.out.printf("Trying to allocate %,d Mb\n", middle/1024/1024);
	         i=middle;
	         if (allocated)
	        	 start = middle;
	         else
	        	 end = middle;
	      } while (end > start);
			   
		return i;
	}
}
