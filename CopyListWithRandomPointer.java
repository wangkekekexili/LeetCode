import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
    	Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
    	
    	RandomListNode sentinel = new RandomListNode(0);
    	RandomListNode oldSentinel = new RandomListNode(0);
    	oldSentinel.next = head;
    	
    	RandomListNode newCurrent = sentinel;
    	RandomListNode oldCurrent = oldSentinel;
    	
    	while (oldCurrent != null) {
    		RandomListNode oldNext = oldCurrent.next;
    		RandomListNode oldRandom = oldCurrent.random;
    		
    		if (oldNext != null) {
    		    RandomListNode newNext = oldToNew.get(oldNext);
    		    if (newNext == null) {
    		    	newNext = new RandomListNode(oldNext.label);
    		    	oldToNew.put(oldNext, newNext);
    		    }
    		    newCurrent.next = newNext;
    		}
    		if (oldRandom != null) {
    			RandomListNode newRandom = oldToNew.get(oldRandom);
    			if (newRandom == null) {
    				newRandom = new RandomListNode(oldRandom.label);
    				oldToNew.put(oldRandom, newRandom);
    			}
    			newCurrent.random = newRandom;
    		}
    		
    		newCurrent = newCurrent.next;
    		oldCurrent = oldCurrent.next;
    		
    	}
    	
    	return sentinel.next;
    	
    }
}
