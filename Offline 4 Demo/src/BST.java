import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST {
    static class Node<E>
    {
        private E value;
        private Node right;
        private Node left;
        public Node(E temp)
        {
            value=temp;
            left=right=null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
    static class Implementation<E extends Comparable <E>>
    {
        Node r_t;
        Implementation()
        {
            r_t=null;
        }
        public void print(){
            print_rec(r_t);
            System.out.println();
        }
        private void print_rec(Node root){

            if(root!=null){
                System.out.print("(");

                System.out.print(root.getValue());
                if(root.getLeft()!=null)
                    print_rec(root.getLeft());
                else if(root.getLeft()==null && root.getRight()!=null)
                    System.out.print("()");

                if(root.getRight()!=null)
                    print_rec(root.getRight());
                else if(root.getRight()==null && root.getLeft()!=null)
                    System.out.print("()");
                System.out.print(")");
            }
        }
        private E minValue(Node root) {
            E minval = (E) root.getValue();
            while (root.getLeft() != null)  {
                minval = (E) root.getLeft().getValue();
                root = root.getLeft();
            }
            return minval;
        }
        Node del_rec(Node root, E value)
        {
            if(root==null)
            {
                return root;
            }
            if(value.compareTo((E) root.getValue())<0)
            {
                root.setLeft(del_rec(root.getLeft(), value));
            }
            else if ( value.compareTo((E)root.getValue())>0)
            {
                root.setRight(del_rec(root.getRight(),value));
            }
            else
            {
                if(root.getLeft()==null)
                {
                    return root.getRight();
                }
                else if(root.getRight()==null)
                {
                    return root.getLeft();
                }
                root.setValue(minValue(root.getRight()));
                root.setRight(del_rec(root.getRight(), (E) root.getValue()));
            }
          return root;
        }
        void delete(E value)
        {
            r_t=del_rec(r_t,value);
            print();
        }
        Node ins_rec(Node root,E key)
        {
            if(root==null)
            {    root=new Node(key);
                return root;
            }
            if(key.compareTo((E)root.getValue())<0)
            {
                root.setLeft(ins_rec(root.getLeft(),key));
            }
            else if(key.compareTo((E)root.getValue())>0)
            {
                root.setRight(ins_rec(root.getRight(),key));
            }
            return root;
        }
        void insert(E value)
        {
            r_t=ins_rec(r_t,value);
            print();
        }
        void in_order_rec(Node root)
        {
            if(root!=null)
            {
                in_order_rec(root.getLeft());
                System.out.print(root.getValue()+ " ");
                in_order_rec(root.getRight());
            }
        }
        void inorder()
        {
            in_order_rec(r_t);
            System.out.println();
        }
        void pre_order_rec(Node root)
        {
            if(root!=null)
            {
                System.out.print(root.getValue()+ " ");
                pre_order_rec(root.getLeft());
                pre_order_rec(root.getRight());
            }
        }
        void preorder()
        {
            pre_order_rec(r_t);
            System.out.println();
        }
        void post_order_rec(Node root)
        {
            if(root!=null)
            {
                post_order_rec(root.getLeft());
                post_order_rec(root.getRight());
                System.out.print(root.getValue()+ " ");
            }
        }
        void postorder()
        {
            post_order_rec(r_t);
            System.out.println();
        }
        Node find_rec(Node root,E key)
        {
            if(root==null || key.compareTo((E)root.getValue())==0)
            {
                return root;
            }
            if(key.compareTo((E)root.getValue())<0)
            {
                return find_rec(root.getLeft(),key);
            }
            else
            {
                return find_rec(root.getRight(),key);
            }
        }
        boolean find(E value)
        {
            if(find_rec(r_t,value)==null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
    public static void main(String[] args) {

        Implementation<Integer> arr = new Implementation<>();

        try {
            File myfile = new File("C:\\Users\\ahmed\\Desktop\\Offline 4 Demo\\Inputtext.txt");
            Scanner inp = new Scanner(myfile);
            while (inp.hasNextLine()) {
                String line = inp.nextLine();
                String [] temp = line.split(" ");

                System.out.println(temp[0] + " " + temp[1]);

                if (temp[0].equals("F")) {
                    boolean res = arr.find(Integer.valueOf(temp[1]));
                    if (res) System.out.println("True");
                    else System.out.println("False");
                }

                if (temp[0].equals("I")) {
                    arr.insert(Integer.valueOf(temp[1]));
                }

                if (temp[0].equals("D")) {
                    arr.delete(Integer.valueOf(temp[1]));
                }

                if (temp[0].equals("T")) {
                    if (temp[1].equals("Pre")) {
                        arr.preorder();
                    } else if (temp[1].equals("Post")) {
                        arr.postorder();
                    } else if (temp[1].equals("In")) {
                        arr.inorder();
                    }
                }
            }
            inp.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }
