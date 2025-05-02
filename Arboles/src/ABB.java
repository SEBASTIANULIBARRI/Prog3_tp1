import java.util.ArrayList;
import java.util.List;

public class ABB<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;


    public ABB() {
        this.root = null;
    }

    private Node<T> insertRecursive(Node<T> arbol, T info) {
        if (arbol == null) {
            return new Node<>(info, null, null);
        } else {
            if (arbol.getInfo().compareTo(info) < 0) arbol.setRight(insertRecursive(arbol.getRight(), info));
            else arbol.setLeft(insertRecursive(arbol.getLeft(), info));
        }
        return arbol;
    }

    public void add(T info) {
        this.root = insertRecursive(root, info);
    }

    public T getRoot() {
        if (isEmpty()) return null;
        return root.getInfo();
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean searchRecursive(Node<T> tree, T element) {
        if (tree == null) return false;

        if (tree.getInfo().equals(element)) return true;

        else if (tree.getInfo().compareTo(element) < 0)
            return searchRecursive(tree.getRight(), element);
        else return searchRecursive(tree.getLeft(), element);
    }

    public boolean hasElem(T info) {
        return searchRecursive(root, info);
    }

    private int heightRecursive(Node<T> tree) {
        if (tree == null) return 0;
        return 1 + Math.max(heightRecursive(tree.getLeft()), heightRecursive(tree.getRight()));
    }

    public int getHeight() {
        return heightRecursive(root);
    }

    private T getMaxRecursive(Node<T> tree) {
        if (tree == null) return null;
        if (tree.getRight() == null) return tree.getInfo();
        else return getMaxRecursive(tree.getRight());
    }

    public T getMaxElem() {
        return getMaxRecursive(root);
    }


    private List<T> getFronteraRecursive(Node<T> tree) {
        List<T> tmp = new ArrayList<>();
        if (tree == null) return tmp;
        if (!tree.hasChilds()) {
            tmp.add(tree.getInfo());
        } else {
            tmp.addAll(getFronteraRecursive(tree.getLeft()));
            tmp.addAll(getFronteraRecursive(tree.getRight()));
        }
        return tmp;

    }

    public List<T> getFrontera() {
        return getFronteraRecursive(root);

    }
    // boolean delete(Integer),

    private Node<T> deleteRecursive(Node<T> tree , T info){
        if (tree == null) return tree;

        if (tree.getInfo().equals(info)){
            if(tree.hasOneChild() || !tree.hasChilds()){
                return tree.child();

            }
            return null;

        }

        if (tree.getInfo().compareTo(info) < 0)
            tree.setRight(deleteRecursive(tree.getRight(),info));
        else deleteRecursive(tree.getLeft(),info);
        return tree;
    }

    public boolean delete(T info){
        root = deleteRecursive(root,info);
        return root == null;

    }

    private List<T> getLongestBranchRecursive(Node<T> tree, int levelActual) {
        List<T> tmp = new ArrayList<>();
        if (tree == null) return tmp;
        if(heightRecursive(tree.getLeft())>heightRecursive(tree.getRight())){
            List<T> left = new ArrayList<>();
            left.add(tree.getInfo());
            left.addAll(getLongestBranchRecursive(tree.getLeft(), levelActual + 1));
            return left;
        }
        else {
            List<T> right = new ArrayList<>();
            right.add(tree.getInfo());
            right.addAll(getLongestBranchRecursive(tree.getRight(), levelActual + 1));
            return right;
        }

    }

    public List<T> getLongestBranch() {
        return getLongestBranchRecursive(root, 0);
    }

    private List<T> getElemAtLevelRecursive(Node<T> tree, int level, int levelActual) {
        List<T> tmp = new ArrayList<>();
        if (tree == null) return tmp;
        if (levelActual == level) {
            tmp.add(tree.getInfo());
        } else {
            tmp.addAll(getElemAtLevelRecursive(tree.getLeft(), level, levelActual + 1));
            tmp.addAll(getElemAtLevelRecursive(tree.getRight(), level, levelActual + 1));
        }

        return tmp;
    }

    public List<T> getElemAtLevel(int level) {
        if (getHeight() <= level) return new ArrayList<>();
        return getElemAtLevelRecursive(root, level, 0);
    }

    //recorridos
    public void printPreOrder() {
        preRecursive(root);
    }

    private void preRecursive(Node<T> tree) {
        if (tree != null) {
            System.out.println(tree.getInfo());
            preRecursive(tree.getLeft());
            preRecursive(tree.getRight());
        }
    }

    public void printInOrder() {
        inRecursive(root);
    }

    private void inRecursive(Node<T> tree) {
        if (tree != null) {
            inRecursive(tree.getLeft());
            System.out.println(tree.getInfo());
            inRecursive(tree.getRight());
        }
    }

    public void printPostOrder() {
        postRecursive(root);
    }

    private void postRecursive(Node<T> tree) {
        if (tree != null) {
            postRecursive(tree.getLeft());
            postRecursive(tree.getRight());
            System.out.println(tree.getInfo());
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<T>(this.root);
    }


}
