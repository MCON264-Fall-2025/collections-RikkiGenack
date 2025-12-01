package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
   /**
    * this method converts a LL to a string and returns it
    * @return the LL as a string
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LLNode<T> curr = head;
        while (curr!= null){
         sb.append(curr.getInfo());
         sb.append(", ");
        curr= curr.getLink();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * this method counts how many times a target matches an elelement in a LL
     * @param target- what you are looking to count
     * @return number of times target was found
     */
    public int count(T target) {
        LLNode<T> curr = head;
        int counter = 0;
        while (curr != null) {
            if (target == null) {
                if (curr.getInfo() == null) {
                    counter++;
                }
            } else {
                if (target.equals(curr.getInfo())) {
                    counter++;
                }
            }
            curr = curr.getLink();
        }
    return counter;
    }
    /**
     * this method removes all instances matching target in a LL
     * @param target- what you want removed
     * @return number of times target was removed(0 if not found)
     */
    public void removeAll(T target) {
        int removed = 0;

        LLNode<T> curr = head;
        LLNode<T> prev = null;

        while (curr != null) {

            // Match condition (including null-safety)
            boolean match = (target == null && curr.getInfo() == null) ||
                    (target != null && target.equals(curr.getInfo()));

            if (match) {
                // remove head
                if (curr == head) {
                    head = curr.getLink();
                    curr = head;
                } else {
                    // remove non-head
                    prev.setLink(curr.getLink());
                    curr = curr.getLink();
                }
                removed++;
            } else {
                // move both pointers forward
                prev = curr;
                curr = curr.getLink();
            }
        }
        numElements -= removed;
    }
}
