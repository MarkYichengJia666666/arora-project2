import java.util.Scanner;
public class kthsmall {
	    public static int  time=0;
	    public static int find(int[] A, int k) {  
	        int value = 0;  
	        int n = A.length;  
	        int group = 5;      
	  
	        while (true) {  
	            int pivot = pivot(A, n, group);  
	            
	            int smallcount = 0;  
	            int largecount = 0;  
	            int data[] = new int[2];  
	  
	            count(A, n, pivot, data);  
	            smallcount = data[0];  
	            largecount = data[1];  
	  
	           if (k < smallcount) {  
	                n = partition(A, n, pivot, true);  
	            } else if (k < n - largecount) {  
	                value = pivot;  
	                break;  
	            } else {  
	                k -= n - largecount;  
	                n = partition(A, n, pivot, false);  
	            } 
	           time++;
	        } 
	        
	        return value;  
	    }  
	  
	    private static int pivot(int[] A, int n, int c) {  
	        while (n > 1) {  
	            int location = 0;  
	            int temp = 0;  
	  
	            for (int start = 0; start < n; start += c) {  
	                int end = start + c;  
	                if (end > n){    
	                    end = n;    
	                }  
	                   
	                for (int i = start; i < end - 1; i++){  
	                    for (int j = i + 1; j < end; j++){  
	                        if (A[j] < A[i]) {  
	                            temp = A[i];  
	                            A[i] = A[j];  
	                            A[j] = temp;  
	                        } 
	                        time++;
	                    }  
	                }  
	                end = (start + end) / 2;  
	                temp = A[end];  
	                A[end] = A[location];  
	                A[location++] = temp;  
	  
	            }  
	            n = location; 
	        }  
	        return A[0];   
	    }  
	  
	    private static void count(int[] a, int n, int pivot, int[] values) {  
	        for (int i = 0; i < n; i++) {  
	            if (a[i] < pivot)  
	            { values[0]++;  }
	            if (a[i] > pivot)  
	            {  values[1]++;  }
	           time++;
	        }  
	    }  
	  
	    private static int partition(int[] a, int n, int pivot, boolean newarrayposition) {  
	        int location = 0;  
	        for (int i = 0; i < n; i++) {  
	            if ((newarrayposition && a[i] < pivot)   || (!newarrayposition && a[i] > pivot))
	            {  
	                int tmp = a[i];  
	                a[i] = a[location];  
	                a[location++] = tmp;  
	            }  
	            time++;
	        }  
	        n = location;  
	        return n;  
	    }  
	  
	    public static void main(String[] args) {  
	        int[] a = { 4, 2, 1, 7, 5, 3, 8, 6, 9, 4, 4, 4, 9,9,9,9,10,11,15,16,17,18,19,20,28,27,26,25,23,22,24,21, 4, 2, 1, 7, 5, 3, 8, 6, 9, 4, 4, 4, 9,9,9,9,10,11,15,16,17,18,19,20,28,27,26,25,23,22,24,21, 4, 2, 1, 7, 5, 3, 8, 6, 9, 4, 4, 4, 9,9,9,9,10,11,15,16,17,18,19,20,28,27,26,25,23,22,24,21, 4, 2, 1, 7, 5, 3, 8, 6, 9, 4, 4, 4, 9,9,9,9,10,11,15,16,17,18,19,20,28,27,26,25,23,22,24,21};  
	        int value=0;
	        
	        System.out.println("Please input k value : ");
			 Scanner sc = new Scanner(System.in);
			 int k = sc.nextInt();
	            value = find(a, k-1);  
	     
	            System.out.println("the "+k+"th smallest number is " + value);  
	            System.out.println(time);  
	    }  
	  
	} 

