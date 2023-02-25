public class TrieB {

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        // int fre;
         Node(){
          for(int i=0; i<26; i++) {
            children[i] = null;
          }
        //   fre =1;
        }
    }
    static int count=1;
    public static Node root = new Node();
    public static void insert(String name) {
        Node curr = root;                                // insert 
        for(int i=0; i<name.length(); i++) {
            int idx = name.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
                count++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


public static boolean search(String str) {
    Node curr = root;
    for(int i=0; i<str.length(); i++) {
        int idx = str.charAt(i) - 'a';
        if(curr.children[idx] == null) {
            return false;
        }
        else{
            curr = curr.children[idx];
        }
    }
    return curr.eow == true;
}

public static boolean Word_break(String s) {
    Node curr = root;
    for(int i=0; i<s.length(); i++) {
        int idx = s.charAt(i) - 'a';
        if (curr.children[idx] == null && curr.eow == true){
            curr = root.children[idx];
            // curr = curr.children[idx];
        }
       else if(curr.children[idx] == null) {
            return false;
        }
        else {
        curr = curr.children[idx];
        }
    }
    return curr.eow == true;
    
}


public static boolean startWith(String prefix) {
    Node curr = root;
    for(int i=0; i<prefix.length(); i++) {
        int idx = prefix.charAt(i) - 'a';
        if(curr.children[idx] == null) {
            return false;
        }
        else{
            curr = curr.children[idx];
        }
    }
   
    return true;
}







public static void getSuffix(String s) {
    for(int i=0; i<s.length(); i++) {
        insert(s.substring(i, s.length()));
    }
}

// public static int nodeCount(Node root, int count) {
//     if(root == null) {
//         return 0;
//     }
//     for(int i=0; i<26; i++) {
//         if(root.children[i] != null) {
//              nodeCount(root.children[i], count+1);
             
//         }
        
//     }
//     return count;
// }


public static void longest(Node root, String ans) {
    if(root == null) {
        System.out.println(ans);

return ;
    }
    // if(!root.eow ) {
    //     return ;
    // }
    for(int i=0; i<26; i++) {
        if(root.children[i] != null) {
        longest(root.children[i], ans+ (char)(i + 'a'));
        }
    }
}


    public static void main(String[] args) {
        String name[] = {"a", "banana", "ap", "app", "appl", "apply", "apple"};
        for(int i=0; i<name.length; i++) {
            insert(name[i]);
        }
        // System.out.println(search("thor"));
        // String s[] = {"i", "like", "samsung", "sam"};
        // System.out.println(Word_break("ilikesung"));
        // System.out.println(startWith("samsun"));
    //  System.out.println(startWith("sams"));
// getSuffix("ababa");
// System.out.println(count);

longest(root, " ");
    }
}
