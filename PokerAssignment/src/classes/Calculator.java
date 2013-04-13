package classes;
/* Decoupling calculations from poker 'front end', best case first. 
 * 
 * 1. a calculator that can be plugged into any card game
 * 2. a 'best hand' calculator that can be plugged into any game needing best hand identifying (poker, blck jack, rummy...)
 * 3. a 'best hand' calculator that can be plugged into any poker game
 * 4. a 'best hand' calculator for this poker game.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Calculator<T> {



	
	/*Calculator needs to take 5 integer pairs and identify best existing hand
	 * 
	 * i) number of same values;
	 * ii) number of same suits
	 * iii) number of consecutive values
	 * 
	 * 
	 */	
	
	/**simple (ish) card matcher
	 * uses static Arrays sort function then matches neighbours and adds card values to arraylist.   
	 * @param values
	 * @return pairedValues
	 */
	public ArrayList<Integer> sameValues(int[] values){
		ArrayList<Integer> pairedValues = new ArrayList<Integer>();
		Arrays.sort(values);
		int i = 1;			 
		while(i<values.length){
			if (values[i]-values[i-1] == 0){					
				pairedValues.add(values[i]);
			}
			i++;	
		}
		return pairedValues;
	}	
	/**
	 * 
	 * @param values
	 * @return consecutives
	 */
	public ArrayList<Integer> consecValues(int[] values){
		ArrayList<Integer> consecutives = new ArrayList<Integer>(); 
		Arrays.sort(values);
		int i = 1;
		while(i<values.length){
			if(values[i]-values[i-1]==1){
				if(i==1){
					consecutives.add(values[i-1]);
				}
				else if (values[i-1]-values[i-2]!=1){
					consecutives.add(values[i-1]);
				}
				consecutives.add(values[i]);
			}
			i++;
		}
		return consecutives;
	}
	
	/**
	 * 
	 * @param values
	 * @return highValues
	 */
	
	public ArrayList<Integer> highValues(int[] values) {
		ArrayList<Integer> highValues = new ArrayList<Integer>();
		for(int value : values){
			if(value==1){
				highValues.add(1);
			}
			else{
				if(value>=11){
					highValues.add(value);
				}
			}
		}
		
		return highValues;
	}
	
	/* not nec
	public ArrayList<Integer> highConsecs(ArrayList<Integer> highValues){
		if(highValues.size()>=2){
			int[] temp = new int[5];
			int i = 0;
			while (i<highValues.size()){
				temp[i] = (highValues.get(i));
				i++;
			}
			consecValues(temp);
			
		}
		return null;
	}
	*/
	
	public ArrayList<Integer> nearlyConsecValues(int[] values){
		ArrayList<Integer> nearConsecs = new ArrayList<Integer>(); 
		Arrays.sort(values);
		int i = 1;
		int diff;
		int count=0;
		int max=0;
		while(i<values.length){
			diff = values[i]-values[i-1];
			if(diff==1 || diff==2){
				if(count==0){ //if this is the first consecutive pair, add a count for the first num
					count++;
				}
				count++; //then add the count for the current num
				
				/*if(i==values.length-1){
					if(max==0){
						max=count;
						nearConsecs = createList(max, i, values);
					}
				}*/	
			}else{
				if(max<count){
					max=count;
					nearConsecs = createList(max, i, values);	
					count=0;
				}
				else{
					count=0;
				}
			}
			i++;
		}
	/*	if (max<count){
			max=count+1;
			i=0;
			if(!nearConsecs.isEmpty()){
				nearConsecs.clear();
			}
			while (i<values.length){
				
				nearConsecs.add(values[i]);
				i++;
			}
		}
		else{
			max++;
		}
		//System.out.println(max); //add one for the first in the list
*/		
		return nearConsecs;
	}
	

	
	public ArrayList<Integer> createList(int size, int index, int[] values){
		ArrayList<Integer> yourList = new ArrayList<Integer>();
		System.out.println(values[index]);
		int i = index-size;
		while(index>i){
			yourList.add(values[index]);
			index--;
		}
		return yourList;
	}
	
	
	/*index = 4;
	 * size=2
	 * i=2
	 * while index>2 add values
	 * index=4 add(4);
	 * index=3 add(3);
	 * index=2 stop.
	 * 
	 * 
	 * */
	
//	http://poker.about.com/od/cardroomscasinos/a/videopokertips.htm
	public void print(ArrayList<T> printValues){
		Iterator<T> it = printValues.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	
	 /* calc then needs to id best potential hand
	 *  which needs an additional 
	 *  iv) mid range runs or skipped numbers
	 *  (not sure how yet - do i-iii first
	 * 
	 */
	
	public static void main (String[] args){
		int[] cardValues= {9,10,3,4,7};
		int[] suitValues = {2,2,2,2,2};
		Calculator<Integer> run =  new Calculator<Integer>();
		//ArrayList<Integer> sameValues = run.sameValues(cardValues);
		run.print(run.nearlyConsecValues(cardValues));
		//run.print(run.sameValues(suitValues));
		//ArrayList<Integer> sameSuits = run.sameValues(suitValues);
		

	}
	
}
