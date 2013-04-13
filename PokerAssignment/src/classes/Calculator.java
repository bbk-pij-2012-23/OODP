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
import java.util.Collections;
import java.util.Iterator;

public class Calculator{



	
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
	 * this doesn't check for invalid combos - its not up to the calculator to do that  
	 * @param values
	 * @return pairedValues
	 */
	public ArrayList<Integer> sameValues(int[] values){
		ArrayList<Integer> pairedValues = new ArrayList<Integer>();
		Arrays.sort(values);
		int i = 1;			 
		while(i<values.length){
			if (values[i]-values[i-1] == 0){
				if(i-1==0){
					pairedValues.add(values[i-1]);
				}
				else if(matchCriteria(values, i-1, 0)==false){
					pairedValues.add(values[i-1]);
				}
				pairedValues.add(values[i]);
			}
			i++;	
		}
		return pairedValues;
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
	
	/*the following two methods have identical code except for this "diff==2". must be a way to 
	 * specify a parameter or something instad 
	 * */
	private boolean matchCriteria(int[] values, int index, int type){
		boolean match = false;
		int diff=values[index]-values[index-1];
		if(type==1){
			if (diff==1){
				match=true;
			}
		}	
		else if(type==2){
			if (diff==1 || diff==2){
				match=true;
			}
		}
		else if(type==0){
			if(diff==0){
				match=true;
			}
		}
		else{
			throw new IllegalArgumentException("that is not a valid type");
		}
		return match;
	}
	
	public ArrayList<Integer> consecValues(int[] values, int type){
		ArrayList<Integer> consecs = new ArrayList<Integer>(); 
		Arrays.sort(values);
		int i = 1;
		int count=0;
		int max=0;
	
		while(i<values.length){
			if(matchCriteria(values, i, type)==true){
				if(count==0){ //if this is the first consecutive pair, add a count for the first num
					count++;
				}
				count++; //then add the count for the current num
			}else{//come to the end of the run, check whether this run was bigger or same as prev run
				if(max<=count){
					max=count;
					consecs = createList(max, i-1, values);	//create a list of the run
					count=0; //reset count
				}
			}
			i++;
		}
		if (max<=count){ //at the end of the loop, check whether the current run the reached the end
			max=count;   //was bigger or same as a prev run, if so replace
			consecs = createList(max, i-1, values);	
		}
		return consecs;
	}
	
/*	public ArrayList<Integer> nearlyConsecValues(int[] values){
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
			}else{//come to the end of the run, check whether this run was bigger or same as prev run
				if(max<=count){
					max=count;
					nearConsecs = createList(max, i-1, values);	//create a list of the run
					count=0; //reset count
				}
			}
			i++;
		}
		if (max<=count){ //at the end of the loop, check whether the current run the reached the end
			max=count;   //was bigger or same as a prev run, if so replace
			nearConsecs = createList(max, i-1, values);	
		}
		return nearConsecs;
	}
	
*/
	
	public ArrayList<Integer> createList(int size, Integer index, int[] values){
		ArrayList<Integer> yourList = new ArrayList<Integer>();
		int i = index-size;
		while(index>i){
			yourList.add(values[index]);
			index--;
		}
		Collections.sort(yourList);
		return yourList;
	}
	
	
	
//	http://poker.about.com/od/cardroomscasinos/a/videopokertips.htm
	public void print(ArrayList<Integer> printValues){
		Iterator<Integer> it = printValues.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	
	
	public static void main (String[] args){
		int[] cardValues= {9,10,3,4,7};
		int[] suitValues = {2,2,2,2,2};
		Calculator<Integer> run =  new Calculator<Integer>();
		//ArrayList<Integer> sameValues = run.sameValues(cardValues);
		run.print(run.consecValues(cardValues, 2));
		//run.print(run.sameValues(suitValues));
		//ArrayList<Integer> sameSuits = run.sameValues(suitValues);
		

	}
	
}
