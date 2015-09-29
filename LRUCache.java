
import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache.
 * 
 * @author kewang
 *
 */
public class LRUCache {
	
	private static class CacheLinkedListNode {
		CacheLinkedListNode previous;
		CacheLinkedListNode next;
		int key;
		int value;
		public CacheLinkedListNode(){}
		public CacheLinkedListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private static class Cache {
		
		private Map<Integer, CacheLinkedListNode> map;
		private CacheLinkedListNode headSentinel;
		private CacheLinkedListNode tailSentinel;
		
		private int capacity;
		private int size;
		
		public Cache(int capacity) {
			map = new HashMap<>();
			headSentinel = new CacheLinkedListNode();
			tailSentinel = new CacheLinkedListNode();
			headSentinel.next = tailSentinel;
			tailSentinel.previous = headSentinel;
			this.capacity = capacity;
			this.size = 0;
		}
		
		public void add(int key, int value) {
			if (map.containsKey(key)) {
				CacheLinkedListNode node = map.get(key);
				node.value = value;
				visit(key);
			} else {
				CacheLinkedListNode node = new CacheLinkedListNode(key, value);
				map.put(key, node);
				size++;
				node.previous = tailSentinel.previous;
				node.next = tailSentinel;
				tailSentinel.previous.next = node;
				tailSentinel.previous = node;
				
				if (size > capacity) {
					size--;
					map.put(headSentinel.next.key, null);
					headSentinel.next = headSentinel.next.next;
					headSentinel.next.previous = headSentinel;
				}
			}
		}
		
		public int visit(int key) {
			CacheLinkedListNode node = map.get(key);
			if (node == null || node.previous == null || node.next == null) {
				return -1;
			}
			node.previous.next = node.next;
			node.next.previous = node.previous;
			node.previous = tailSentinel.previous;
			node.next = tailSentinel;
			tailSentinel.previous.next = node;
			tailSentinel.previous = node;
			return node.value;
		}
		
	}
	
	private Cache cache;
	
    public LRUCache(int capacity) {
    	cache = new Cache(capacity);
    }
    
    public int get(int key) {
    	return cache.visit(key);
    }
    
    public void set(int key, int value) {
        cache.add(key, value);
    }
}