package leetcode.editor.cn.zs.zs311;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/18/11:56
 */
public class T44 {

    @Test
    public void test(){
        for (int i : sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})) {
            System.out.println(i);
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie=new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        int[] ans=new int[words.length];
        Arrays.fill(ans,1);
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            for (int j = 0; j < length; j++) {
                if (trie.startsWith(words[i].substring(0,j+1))){

                    ans[i]++;
                }
            }
        }

        return ans;
    }
}


class Trie {
        class TrieNode {
            boolean end;
            TrieNode[] tns = new TrieNode[26];
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new TrieNode();
                p = p.tns[u];
            }
            p.end = true;
        }

        public boolean search(String s) {
            TrieNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return p.end;
        }

        public boolean startsWith(String s) {
            TrieNode p = root;
            for(int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return true;
        }
    }


