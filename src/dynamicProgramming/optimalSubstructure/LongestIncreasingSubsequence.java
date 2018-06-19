package dynamicProgramming.optimalSubstructure;

public class LongestIncreasingSubsequence {
	public static void main(String[] arg) {
		int arr[] = { 50, 3, 10, 7, 40, 80 };
		System.err.println(lis(arr, arr.length));
	}

	static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}
	public void findLongestSub(int arr[]){

    int len =  arr.length;
    int i,k;
    int storeMax[] = new int[len];
    storeMax[0]=1;
    int currentMax;
    
    for(i=1;i<len;i++){
        currentMax=0;
        
        for(k=i-1;k>=0;k--){
            if(arr[k]<arr[i])
                if(storeMax[k]>currentMax)
                    currentMax=storeMax[k];
            
        }

        storeMax[i]=currentMax+1;  
    }
    
    currentMax=1;
    for(i=1;i<len;i++)
        if(storeMax[i]>currentMax)
            currentMax=storeMax[i];
            
    System.out.println("Longest Pattern length is "+currentMax);

}
}
