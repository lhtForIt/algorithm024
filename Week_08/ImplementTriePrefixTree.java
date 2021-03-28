//题号：208
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 560 👎 0


import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("alone");
        trie.search("alone");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

        /**
         * 数组实现，适用于知道每个节点的范围，这里是已知只有26个小写字母，但对常规情况不大试用。
         * 这里准确的说应该是TrieNode数组，但是为了一个数组新建一个类没多大必要，因此可以混用，
         * 知道是怎么个意思就行
         */
//        private Trie[] next;
//        private boolean isEnd;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public Trie() {
//            next = new Trie[26];
//            isEnd = false;
//        }
//
//        /**
//         * Inserts a word into the trie.
//         */
//        public void insert(String word) {
//            if (word == null || word.length() == 0) return;
//            Trie curr = this;
//            for (char ch : word.toCharArray()) {
//                int u = ch - 'a';
//                //如果null则新new一个节点
//                if (curr.next[u] == null) curr.next[u] = new Trie();
//                //否则找到下一个节点
//                curr = curr.next[u];
//            }
//            //赋值完成将状态置成true
//            curr.isEnd = true;
//        }
//
//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//            Trie node = searchPrefix(word);
//            return node != null && node.isEnd;
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//            Trie node = searchPrefix(prefix);
//            return node != null;
//        }
//
//
//        private Trie searchPrefix(String word) {
//            Trie node = this;
//            for (char c : word.toCharArray()) {
//                node = node.next[c - 'a'];
//                if (node == null) return null;
//            }
//            return node;
//        }


        /**
         * hashMap实现，对于任意长度节点都能cover，试用于一般场景
         */
          TrieNode head;
          /** Initialize your data structure here. */
          public Trie() {
              head = new TrieNode();
          }

          /** Inserts a word into the trie. */
          public void insert(String word) {
              if(word == null)
                  return;
              TrieNode node = head;
              for(char ch : word.toCharArray()) {
                  if(!node.charToNode.containsKey(ch)){
                      node.charToNode.put(ch, new TrieNode());
                  }
                  node = node.charToNode.get(ch);
              }
              node.isEnd = true;
          }

          /** Returns if the word is in the trie. */
          public boolean search(String word) {
//              if(word == null) return false;
              TrieNode node = searchPrefix(word);
              return node != null && node.isEnd;

          }

          /** Returns if there is any word in the trie that starts with the given prefix. */
          public boolean startsWith(String prefix) {
//              if(prefix == null) return false;
              TrieNode node = searchPrefix(prefix);
              return node != null;

          }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = head;
            for(char ch : prefix.toCharArray()) {
                if(!node.charToNode.containsKey(ch)) return null;
                node = node.charToNode.get(ch);
            }
            return node;
        }


        class TrieNode{
            Map<Character, TrieNode> charToNode;
            boolean isEnd = false;
            public TrieNode(){
                charToNode = new HashMap();
            }
        }


    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}