package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

import java.util.Random;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    /**
     * The grab() method grabs any random element from the collection.
     * @return the randomly selected element or null if the bad is empty
     */
    @Override
    public T grab() {
        if (numElements == 0) return null;
        Random rand = new Random();
        T grabbed=  elements[rand.nextInt(numElements-1)];
        numElements--;
        return grabbed;
    }

    /**
     * The count() method counts how many times a certain element appears in a collection
     * @param the element you want to count(the target)
     * @return amount of times target appeared in collection
     */
    @Override
    public int count(T target) {
        int counter = 0;
            for(int i = 0; i< numElements; i++) {
                if (elements[i].equals(target)) {
                counter++;
                }
            }

        return counter;
    }

    /**
     * The removeAll() removes all instances of specific element in a collection.
     * @param the element you want removed (also the target)
     * @return number of elements removed or 0 if the element was not found in the collection
     */

    @Override
    public int removeAll(T target) {
        int counter = 0;
        for (int i = 0; i < numElements;) {
            if (elements[i].equals(target)) {
                elements[i] = elements[numElements - 1];
                elements[numElements - 1] = null;
                numElements--;
                counter++;
            } else
                i++;
        }
        return counter;
    }

    /**
     * the clear method clears all elements from a collection
     **/
    @Override
    public void clear() {
            for(int i=0; i < numElements; i ++) {
            elements[i]=null;
            }
            numElements=0;

    }
    // Which SOLID principles is being applied here?
    /**Single Responsibility Principle — Each class in the design has one clear purpose.
     ArrayCollection manages the underlying array and collection mechanics,while BasicBag
     only implements the bag-specific operations like grab, count, and removeAll.
     Liskov Substitution Principle — BasicBag extends ArrayCollection and can be used
     anywhere a Collection is expected without breaking behavior.
     Interface Segregation Principle — BagInterface defines only the methods needed by a Bag,
     instead of forcing all collection types to implement unused operations.I had AI generate this*/
}