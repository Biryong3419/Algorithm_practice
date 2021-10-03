import java.util.Arrays;
import java.util.TreeSet;

class Node {
    char value;
    Node leftChild;
    Node rightChild;

    public Node(char value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree {
    Node rootNode = null;

    /**
     * 새로운 노드 삽입
     */
    public void insertNode(char element) {

        /*
         * 루트가 빈 경우, 즉 아무 노드도 없는 경우
         */
        if (rootNode == null) {
            rootNode = new Node(element);
        } else {
            Node head = rootNode;
            Node currentNode;

            while (true) {
                currentNode = head;

                /*
                 * 현재의 루트보다 작은 경우, 왼쪽으로 탐색을 한다.
                 */
                if (head.value > element) {
                    head = head.leftChild;

                    /*
                     * 왼쪽 자식 노드가 비어있는 경우, 해당 위치에 추가할 노드를 삽입한다.
                     * 현재 currenNode head를 가리키고 있다.
                     */
                    if (head == null) {
                        currentNode.leftChild = new Node(element);
                        break;
                    }
                } else {
                    /*
                     * 현재의 루트보다 큰 경우, 오른쪽으로 탐색을 한다.
                     */
                    head = head.rightChild;

                    /*
                     * 오른쪽 자식 노드가 비어있는 경우, 해당 위치에 추가할 노드를 삽입한다.
                     * 현재 currenNode head를 가리키고 있다.
                     */
                    if (head == null) {
                        currentNode.rightChild = new Node(element);
                        break;
                    }
                }
            }
        }
    }


    /**
     * 후위 순회
     */
    public void postorderTree(Node root, int depth) {
        if (root != null) {
            postorderTree(root.leftChild, depth + 1);
            postorderTree(root.rightChild, depth + 1);
            System.out.println(root.value);
        }
    }

}


class Solution11 {


    public static String solution(String message) {
        System.out.println("!!@!@#!@#@!");
        BinaryTree bt = new BinaryTree();

        for(int i = 0; i < message.trim().length(); i++) {
            char currentChar = message.trim().charAt(i);
            bt.insertNode(currentChar);
            System.out.println("Binary Tree >>>");
            bt.postorderTree(bt.rootNode,0);
        }

        System.out.println("Binary Tree >>>");
        bt.postorderTree(bt.rootNode,0);


        return "aa";
    }


    public static void main(String[] args) {
        solution("ABCDEF");
    }

}
