package lec_10_class;

public class merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int [] arr={2,8,9,6,6,76,45,34};
         int [] res=merge_sort(arr,0,arr.length-1);
         for(int i=0;i<arr.length;i++){
        	 System.out.println(res[i]);
         }
	}
	public static int [] merge_sort(int [] arr, int low ,int high){
		if(low==high){
			int [] base = new int [1];
			base[0]=arr[low];
			return base;
		}
		int mid=(low+high)/2;
		int [] fhalf=merge_sort(arr,low,mid);
		int [] shalf=merge_sort(arr,mid+1,high);
		int [] fres=merge(fhalf,shalf);
		return fres;
	}
	public static int[] merge(int [] one, int [] two){
		int [] merge=new int[one.length+two.length];
		int i,j,k;
		if(one.length>two.length){
		} else {
		}
		for(i=0,j=0,k=0;i<one.length&&j<two.length;){
			if(one[i]>two[j]){
				merge[k++]=two[j++];
			}
			else{
				merge[k++]=one[i++];
			}
		}
		if(i>=0){
			while(i<one.length){
				merge[k++]=one[i++];
			}
		}
		if(j>=0){
			while(j<two.length){
				merge[k++]=two[j++];
			}
		}
		return merge;
	}

}
