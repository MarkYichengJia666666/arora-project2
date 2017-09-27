
public class sort {
	
	
	public static void main(String[] args) {  
    int start=0,end=6;
    int A[]={6,5,4,3,2,1};
    int tmp=0;
	for (int i = start; i < end - 1; i++){  
        for (int j = i + 1; j < end; j++){  
            if (A[j] < A[i]) {  
                tmp = A[i];  
                A[i] = A[j];  
                A[j] = tmp;  
            }  
        }  
	}
	for(int k=0;k<6;k++)
	{System.out.println(A[k]);  }
	}
}
	
