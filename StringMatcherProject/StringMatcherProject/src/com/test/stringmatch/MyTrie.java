//I know JNI is expensive. This is just for demo
public class MyTrie {
	public boolean addString(String s, int id, MatchType type) {
		// Use JNI to call the add_string_to_trie C impl
		return true;
	}

	public boolean deleteString(String s) {
		// Use JNI to call the delete_string_from_trie C impl
		return false;
	}

	public int lookup(String s) {
		// Use JNI to call the search_string_to_trie C impl
		return 0;
	}
}
