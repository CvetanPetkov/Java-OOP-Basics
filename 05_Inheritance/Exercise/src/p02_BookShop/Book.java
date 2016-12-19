package p02_BookShop;

public class Book {

    private String title;
    private String author;
    private Double price;

    protected Book(String title, String author, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }
    protected void setTitle(String title) {
        if (title.length() > 3) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title not valid!");
        }
    }

    private String getAuthor() {
        return this.author;
    }
    protected void setAuthor(String author) {
        if (author != null && author.length() > 0) {
            String[] authorNames = author.split("[\\s]+");
            if (authorNames.length > 1) {
                String authorLastName = authorNames[1];
                if (Character.isDigit(authorLastName.charAt(0))) {
                    throw new IllegalArgumentException("Author not valid!");
                } else {
                    this.author = author;
                }
            } else {
                this.author = author;
            }
        } else {
            throw new IllegalArgumentException("Author not valid!");
        }

    }

    protected Double getPrice() {
        return this.price;
    }
    protected void setPrice(Double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Type: %s\nTitle: %s\nAuthor: %s\nPrice: %.1f\n",
                this.getClass().getSimpleName(),
                this.getTitle(), this.getAuthor(), this.getPrice()));
        return sb.toString();
    }
}
