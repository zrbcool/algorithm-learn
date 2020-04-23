package leetcode;

import org.assertj.core.util.Lists;

import java.util.*;

public class Solution_0648 {
    /**
     * 单词替换
     * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     *
     * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     *
     * 你需要输出替换之后的句子。
     *
     * 示例 1:
     *
     * 输入: dict(词典) = ["cat", "bat", "rat"]
     * sentence(句子) = "the cattle was rattled by the battery"
     * 输出: "the cat was rat by the bat"
     * 注:
     *
     * 输入只包含小写字母。
     * 1 <= 字典单词数 <=1000
     * 1 <=  句中词语数 <= 1000
     * 1 <= 词根长度 <= 100
     * 1 <= 句中词语长度 <= 1000
     */
    class Trie {
        private class DicNode {
            Character character;
            Map<Character, DicNode> map = new HashMap<>();
            boolean end = false;
            Set<Integer> index = new HashSet<>();

            public DicNode(Character character) {
                this.character = character;
            }
        }
        /** Initialize your data structure here. */
        public Trie() {

        }

        private DicNode dic = new DicNode('z');

        /** Inserts a word into the trie. */
        public void insert(String word, int index) {
            if (word == null || "".equals(word)) return;
            DicNode cur = this.dic;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                if (cur.map.containsKey(charAt)) {
                    cur = cur.map.get(charAt);
                } else {
                    DicNode node = new DicNode(charAt);
                    cur.map.put(charAt, node);
                    cur = node;
                }
            }
            if (cur != null) {
                cur.end = true;
                cur.index.add(index);
            }
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public DicNode startsWith(String prefix) {
            if (prefix == null || "".equals(prefix)) return null;
            DicNode cur = this.dic;
            for (int i = 0; i < prefix.length(); i++) {
                char charAt = prefix.charAt(i);
                if (!cur.map.containsKey(charAt)) {
                    return null;
                }
                cur = cur.map.get(charAt);
            }
            if (cur == this.dic) {
                cur = null;
            }
            return cur;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.equals("")) return null;
        Trie trie = new Trie();
        String[] split = sentence.split(" ");
        for (int index = 0; index < split.length; index++) {
            trie.insert(split[index], index);
        }

        dict.sort(Comparator.comparingInt(String::length));
        Set<Integer> visited = new HashSet<>();
        for (String dic : dict) {
            Trie.DicNode dicNode = trie.startsWith(dic);
            if (dicNode != null) {
                dfs(dicNode, split, dic, visited);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void dfs(Trie.DicNode dicNode, String[] split, String dic, Set<Integer> visited) {
        if (dicNode == null) return;
        if (dicNode.end) {
            for (Integer index : dicNode.index) {
                if (visited.contains(index)) continue;
                split[index] = dic;
                visited.add(index);
            }
        }
        for (Trie.DicNode value : dicNode.map.values()) {
            dfs(value, split, dic, visited);
        }
    }

    public static void main(String[] args) {
        /**
         *
         * ["e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"]
         * "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"
         *
         */
        String dic[] = new String[]{"e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"};
        String replaceWords = new Solution_0648().replaceWords(Lists.newArrayList(dic), "i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp");
        System.out.println(replaceWords);

    }
}
