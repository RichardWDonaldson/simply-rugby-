package controller;

import java.util.ArrayList;

/**
 * Created by Richard on 10/05/2017.
 */
/**
 * @author Richard
 *
 * @param <T>
 */
public class TwoDimArrayList<T> extends ArrayList<ArrayList<T>> {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6688282539725738766L;



	
	/**
	 * 
	 */
	public TwoDimArrayList() {

    }

    /**
     * @param i
     * @param element
     */
    public void addToInnerArray(int i, T element) {
        while (i >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ((ArrayList<T>)this.get(i)).add(element);

    }



	/**
	 * @param i
	 * @param j
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void addToInnerArray(int i, int j, T element) {
        while(i >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<Object> inner = (ArrayList<Object>)this.get(i);

        while(j >= inner.size()) {
            inner.add((Object)null);
        }

        inner.set(j, element);
    }

	
	
	
	
	
}
