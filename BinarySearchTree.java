import java.util.ArrayList;

public class BinarySearchTree
{
    /** The Node at the root of a tree */
    private Node root;

    /**
     * Constructs an empty tree.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Inserts a new node into the tree.
     *
     * @param obj the object to insert
     */
    public void add(Comparable obj)
    {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null)
            root = newNode;
        else
            root.addNode(newNode);
    }

    /**
     * Tries to find a specific object in the tree. It uses only the data
     * from the input object to search the tree using the compareTo() method
     * specified for the class
     *
     * @param obj - object with the data (key of) the object to be found
     * @return reference to the object, if it is contained in the tree,
     * null if not
     */
    public Comparable find(Comparable obj)
    {
        Node current = root;
        while (current != null)
        {
            int d = current.data.compareTo(obj);
            if (d == 0)
            {
                return current.data;
            }
            else if (d > 0)
                current = current.left;
            else
                current = current.right;
        }
        return null;
    }

    /**
     * Tries to find and remove an object from the tree. It uses only the data
     * from the input object to search the tree using the compareTo() method
     * specified for the class. Rearranges the tree members after removal.
     * Does nothing if the object is not contained in the tree.
     *
     * @param obj the object to remove
     */
    public void remove(Comparable obj)
    {
        // Find node to be removed
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        while (!found && toBeRemoved != null)
        {
            int d = toBeRemoved.data.compareTo(obj);
            if (d == 0)
                found = true;
            else
            {
                parent = toBeRemoved;
                if (d > 0)
                    toBeRemoved = toBeRemoved.left;
                else
                    toBeRemoved = toBeRemoved.right;
            }
        }

        if (!found)
            return;

        // toBeRemoved contains obj
        // If one of the children is empty, use the other
        if (toBeRemoved.left == null || toBeRemoved.right == null)
        {
            Node newChild;
            if (toBeRemoved.left == null)
                newChild = toBeRemoved.right;
            else
                newChild = toBeRemoved.left;

            if (parent == null) // Found in root
                root = newChild;
            else if (parent.left == toBeRemoved)
                parent.left = newChild;
            else
                parent.right = newChild;
            return;
        }

        // Neither subtree is empty
        // Find smallest element of the right subtree
        Node smallestParent = toBeRemoved;
        Node smallest = toBeRemoved.right;
        while (smallest.left != null)
        {
            smallestParent = smallest;
            smallest = smallest.left;
        }

        // smallest contains smallest child in right subtree
        // Move contents, unlink child
        toBeRemoved.data = smallest.data;
        if (smallestParent == toBeRemoved)
            smallestParent.right = smallest.right;
        else
            smallestParent.left = smallest.right;
    }

    /**
     * Prints the contents of the tree in sorted order.
     */
    public void print()
    {
        print(root);
        System.out.println();
    }

    /**
     * Prints a node and all of its descendants in sorted order.
     *
     * @param parent the root of the subtree to print
     */
    private void print(Node parent)
    {
        if (parent == null)
            return;
        print(parent.left);
        System.out.print(parent.data.toString());
        print(parent.right);
    }

    /**
     * Returns a new ArrayList of objects
     *
     * @return an Arraylist Object with / without node components
     */
    public ArrayList<Object> getList()
    {
        ArrayList<Object> list = new ArrayList<Object>();
        getList(list, root);
        return list;
    }

    /**
     * Returns an empty or complete tree based on the root node
     *
     * @param list - the list to which elements are to be added
     * @param parent - the root of the tree to be created
     */
    private void getList(ArrayList<Object> list, Node parent)
    {
        if (parent == null)
            return;
        getList(list,parent.left);
        list.add(parent.data);
        getList(list, parent.right);
    }

    /**
     * A node of a tree stores a data item and references
     * to the left and right child nodes.
     */
    class Node
    {
        /** the data object in the node */
        public Comparable data;
        /** Reference to the node to this node's left */
        public Node left;
        /** Reference to the node to this node's right */
        public Node right;

        /**
         * Inserts a new node as a descendant of this node.
         *
         * @param newNode the node to insert
         */
        public void addNode(Node newNode)
        {
            int comp = newNode.data.compareTo(data);
            if (comp < 0)
            {
                if (left == null)
                    left = newNode;
                else
                    left.addNode(newNode);
            }
            else if (comp > 0)
            {
                if (right == null)
                    right = newNode;
                else
                    right.addNode(newNode);
            }
        }
    }
}