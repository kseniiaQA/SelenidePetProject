package API;

import java.util.Date;

public class UserData {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private Date publish_date;
    private String publisher;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    private Integer pages;

    public UserData(String isbn, String title, String subTitle, String author, Date publish_date, String publisher, Integer pages, String description, String website) {
        this.isbn = isbn;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.publish_date = publish_date;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.website = website;
    }

    private String description;
    private String website;
}

