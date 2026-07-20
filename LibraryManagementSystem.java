package LibraryManagementSystem;
import java.util.*;
class Book {
    String title;
    String isbn;
    int publicationYear;

    public Book(String title, String isbn, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", ISBN: " + isbn + ", Year: " + publicationYear;
    }
}
class LinkedListNode {
    Book book;
    LinkedListNode next;

    public LinkedListNode(Book book) {
        this.book = book;
        this.next = null;
    }
}

// Binary Search Tree (BST) class
class BST {
    Book root;
    BST left, right;

    public BST() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public void insert(Book book) {
        if (this.root == null) {
            this.root = book;
        } else if (book.publicationYear < this.root.publicationYear) {
            if (this.left == null) this.left = new BST();
            this.left.insert(book);
        } else if (book.publicationYear > this.root.publicationYear) {
            if (this.right == null) this.right = new BST();
            this.right.insert(book);
        }
    }

    public void inOrderTraversal() {
        if (this.left != null) this.left.inOrderTraversal();
        if (this.root != null) System.out.println(this.root);
        if (this.right != null) this.right.inOrderTraversal();
    }

    public void findBooksInYearRange(int startYear, int endYear) {
        if (this.root == null) return;
        if (this.left != null) this.left.findBooksInYearRange(startYear, endYear);
        if (this.root.publicationYear >= startYear && this.root.publicationYear <= endYear)
            System.out.println(this.root);
        if (this.right != null) this.right.findBooksInYearRange(startYear, endYear);
    }
}

public class LibraryManagementSystem {
    LinkedListNode head = null;
    HashMap<String, Book> bookMap = new HashMap<>();
    BST tree = new BST();
    public void addBook(String title, String isbn, int year) {
        Book book = new Book(title, isbn, year);

        // Add to LinkedList
        LinkedListNode newNode = new LinkedListNode(book);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        bookMap.put(isbn, book);
        tree.insert(book);
    }
    public void removeBook(String isbn) {
        // Check if the book exists in the HashMap
        Book bookToRemove = bookMap.get(isbn);
        if (bookToRemove == null) {
            System.out.println("Book not found.");
            return;
        }
        // Remove from HashMap
        bookMap.remove(isbn);
        // Remove from LinkedList
        removeFromLinkedList(isbn);
        // Remove from BST
        tree = removeFromBST(tree, bookToRemove);
        System.out.println("Book removed successfully.");
    }
    // Helper method to remove a book from LinkedList
    private void removeFromLinkedList(String isbn) {
        if (head == null) return;
        if (head.book.isbn.equals(isbn)) {
            head = head.next;
            return;
        }
        LinkedListNode current = head;
        while (current.next != null) {
            if (current.next.book.isbn.equals(isbn)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    private BST removeFromBST(BST root, Book book) {
        if (root == null) return null;

        if (book.publicationYear < root.root.publicationYear) {
            root.left = removeFromBST(root.left, book);
        } else if (book.publicationYear > root.root.publicationYear) {
            root.right = removeFromBST(root.right, book);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            BST minNode = findMin(root.right);
            root.root = minNode.root;
            root.right = removeFromBST(root.right, minNode.root);
        }
        return root;
    }
    private BST findMin(BST root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Books ");
            System.out.println("2. Remove Book ");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Search by Title");
            System.out.println("5. Display Books by Publication Year");
            System.out.println("6. Find Books in Year Range");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("How many books do you want to add? ");
                    int numBooks = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numBooks; i++) {
                        System.out.println("Enter details for book " + (i + 1) + ":");
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        library.addBook(title , isbn , year);
                    }
                    break;
                case 2: // Remove Book
                    System.out.print("Enter ISBN to remove: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBook(removeIsbn);
                    break;


                case 3: // Search by ISBN
                    System.out.print("Enter ISBN to search: ");
                    String searchIsbn = scanner.nextLine();
                    Book book = library.bookMap.get(searchIsbn);
                    if (book != null) System.out.println(book);
                    else System.out.println("Book not found.");
                    break;

                case 4: // Search by Title
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    LinkedListNode temp = library.head;
                    boolean found = false;
                    while (temp != null) {
                        if (temp.book.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println(temp.book);
                            found = true;
                            break;
                        }
                        temp = temp.next;
                    }
                    if (!found) System.out.println("Book not found.");
                    break;

                case 5: // Display Books by Publication Year
                    System.out.println("Books by publication year:");
                    library.tree.inOrderTraversal();
                    break;

                case 6: // Find Books in Year Range
                    System.out.print("Enter start year: ");
                    int startYear = scanner.nextInt();
                    System.out.print("Enter end year: ");
                    int endYear = scanner.nextInt();
                    library.tree.findBooksInYearRange(startYear, endYear);
                    break;

                case 7: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

