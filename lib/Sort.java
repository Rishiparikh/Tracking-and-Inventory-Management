import java.util.*;
/**
 *  Description of the Class
 *
 * @author  Rishi Parikh
 * period   #3
 */
public class Sort{
 /**
   *  Helper method to the mergeSort
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
	private void merge(ArrayList<Comparable> a,int first,int mid,int last){
		ArrayList<Comparable> temp= new ArrayList<Comparable>(a.size());
		int i=first,j=mid;
		while(i<mid&&j<=last){
		   if(a.get(i).compareTo(a.get(j))>0) {
		      temp.add(a.get(j));
		      j++;
		   } else {
		      temp.add(a.get(i));
		      i++;
		   }//1 compare, 1 add, 3 gets
			
		}
		while(i<mid){
			temp.add(a.get(i++));//1 add, 1 get
			
		}
		while(j<=last){
			temp.add(a.get(j++));//1 add, 1 get
			
		}
		for(int b = first; b<=last;b++){
			a.set(b,temp.get(b-first));//1 set, 1 get
			
		}
	}
  /**
   *  Recursive mergesort of an arrayList to quickly sort lists throughout the code
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
	public void mergeSort(ArrayList<Comparable> a,int first,int last){
		steps = 0;//resets at the beginning
		if(!(last-first<1)){
			int mid=(last+first)/2;
			mergeSort(a,first,mid);
			mergeSort(a,mid+1,last);
			merge(a,first,mid+1,last);
		}
	}

}
