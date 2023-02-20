import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;
import javax.management.relation.Role;

public class BST{
static class Node {
    int data;
    Node right, left;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}





public static Node findInorderSuccesor(Node root) {
    while(root.left != null) {
root = root.left;
    }
    return root;
}

public static Node remove(Node root, int val) {
    
  if(root.data > val) {
    root.left = remove(root.left, val);     
  }
 else  if (root.data < val) {
    root.right = remove(root.right, val);
  }
  if(root.data == val) {
    if(root.right == null && root.left ==null) {
        root = null;                                     // no child
        return root;
    }
    if(root.right == null) {
        return root.left;                                 // one child
    }
    if(root.left == null) {
        return root.right;
    }
   
        Node IS = findInorderSuccesor(root.right);
        root.data = IS.data;                                // two child
       root.right= remove(root.right, IS.data) ;
}
    return root;
  }
public static boolean search(Node root, int key) {
    if(root == null) {
        
        return false;
    }
    if(root.data == key) {
       
return true;
    }
    if(root.data > key) {
       return search(root.left, key);

    }
    else{
    return search(root.right, key);
}
}

public static void inRange(Node root, int n1, int n2) {
    if(root == null) {
        return;
    }
    if(root.data >= n1 && root.data <= n2) {
        inRange(root.left, n1, n2);
        System.out.print(root.data + " ");
        inRange(root.right, n1, n2);
    }
    else if(root.data < n1) {
        inRange(root.left, n1, n2);
    }
    else {
        inRange(root.right, n1, n2);
    }
}

public static Node allPath(Node root, ArrayList<Integer> list) {
    if(root == null) {
        return root;
    }
list.add(root.data);
    Node leftPath = allPath(root.left, list);
    Node rightPath = allPath(root.right, list);
    if(leftPath == null && rightPath == null) {
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + "-");
        }
        System.out.println();
           
    }
    list.remove(list.size()-1); 
    return root;
}



public static Node change(Node root) {
if(root == null)  {
    return null;
}
Node leftvala = change(root.left);
Node rightvala = change(root.right);

root.left = rightvala;
root.right = leftvala;
return root;

}


// public static boolean isValidate(Node root) {
//     if(root == null || root.right == null || root.left == null) {
//         return true;
//     }

//     if(root.data >= root.right.data || root.data <= root.left.data) {
//         return false;
//     }
//     if(!isValidate(root.left)) {
//         return false;
//     }
//     if(!isValidate(root.right)) {
//         return false;
//     }
//     return true;
// }

public static boolean isValidate(Node root , int max, int min) {
if(root == null) {
    return true;
}

if(root.data < min || root.data > max) {
    return false;
}
return isValidate(root.left, root.data, min) && isValidate(root.right, max, root.data);
}


public static int largestBST(Node root) {
    if(root == null) {
        return 0;
    }
    int leftcount =largestBST(root.left);
    int rightcount = largestBST(root.right);
    return leftcount + rightcount +1;
}



public static Node balancedBST(ArrayList<Integer> list, int si, int ei) {
    int mid = si +(ei - si)/2;
if(ei< si) {
    return null;
}
Node root = new Node(list.get(mid));
root.left = balancedBST(list, si, mid-1);
root.right = balancedBST(list, mid+1, ei);
return root;


}
public static Node insert(Node root, int val) {
    if(root == null) {
root = new Node(val);
return root;
    }
    if(root.data > val) {
     root.left =   insert(root.left, val);
    }
    else {
        root.right = insert(root.right, val);
    } 
    return root;
}


public static void inorderSequence(ArrayList<Integer> list, Node root) {
   if(root == null) {
    return;
   }
   inorderSequence(list, root.left);
   list.add(root.data);
   inorderSequence(list, root.right);

}

public static void inorder(Node root) {
    if(root == null) {
        return;
    }
    
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
}
public static void preorder(Node root) {
    if(root == null) {
        return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    
    preorder(root.right);
}

public static Node merge (Node root1, Node root2) {
    ArrayList<Integer> join = new ArrayList<>();

 inorderSequence(join, root1);
 inorderSequence(join, root2);
Collections.sort(join);
return balancedBST(join, 0, join.size()-1);


}



    public static void main(String args[]) {
        //int values[] = {8, 5, 3, 6, 10 ,11 , 14};
        // Node root = null;
       


//search(root, 4);
//inorder(root);
;
//root = remove(root, 4);
//inorder(root);

//inRange(root, 3, 7);
//ArrayList<Integer> list = new ArrayList<>();
//allPath(root, list);

//System.out.println(isValidate(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
// change(root);


// Node root = new Node(8);
// root.left = new Node(6);
// root.left.left = new Node(5);
// root.left.left = new Node(3);
// root.right = new Node(10);
// root.right.right = new Node(11);
// root.right.right = new Node(13);
// // int arr[] = {3, 5, 6, 8, 10, 11, 12};
// ArrayList<Integer> list = new ArrayList<>();

// inorderSequence(list, root);
//  root = balancedBST(list, 0, list.size()-1);
//  for(int i=0; i<list.size(); i++)   {
//     root =  insert(root, list.get(i));
//   }
//  inorder(root);
// Node root =  new Node(50);
//   root.left=  new Node(30);
//   root.left.left = new Node(5);
//   root.left.right= new Node(20);
//   root.right = new Node(60);

//   root.right.left = new Node(45);
//   root.right.right = new Node(70);
//  isValidate(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
// int largest = Integer.MIN_VALUE;
// if(isValidate(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
//     int count = largestBST(root);
//     if(count >largest) {
//         largest = count;
//     }
// }

Node root1 = new Node(2);
root1.left = new Node(1);
root1.right = new Node(4);
Node root2 = new Node(9);
root2.left = new Node(3);
root2.right = new Node(12);
Node root= merge(root1, root2);
 preorder(root);

 

      }
}