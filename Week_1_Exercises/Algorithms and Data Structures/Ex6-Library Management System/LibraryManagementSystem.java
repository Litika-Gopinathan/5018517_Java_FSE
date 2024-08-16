
public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        this.setBooks(new Book[capacity]);
        this.setSize(0);
    }

    public void addBook(Book book) {
        if (getSize() == getBooks().length) {
            System.out.println("Library is full!!! Cannot add more books.");
            return;
        }
        getBooks()[size++] = book;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < getSize(); i++) {
            if (getBooks()[i].getTitle().equalsIgnoreCase(title)) {
                return getBooks()[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = getSize() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = getBooks()[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return getBooks()[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    
    // getters and setters
	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

