
public class median {  
	  
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
	                values[0]++;  
	            if (a[i] > pivot)  
	                values[1]++;  
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
	        }  
	        n = location;  
	        return n;  
	    }  
	  
	    public static void main(String[] args) {  
	        int[] a = { 1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 4};  
	        int k=a.length-1;
	        float value=0;
	        
	        if(k%2==0)
	        {
	        	k=k/2;
	            value = find(a, k);  
	            System.out.println("the median number is " + value);  
	        }
	        else
	        {k=k/2;
             value = find(a, k); 
	         k=k+1;
	         value =(find(a,k)+value)/2;
	         System.out.println("the median number is " + value);  
	        }
	    }  
	  
	} 
