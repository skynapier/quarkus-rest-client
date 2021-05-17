package tian.rest.client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    public String kind;
    public Integer totalItems;
    public List<Item> items;


    public static class Item{

        public String kind;
        public String id;
        public String etag;
        public String selfLink;

        public Volume volumeInfo;

    }

    public static class Volume{
        public String title;
        public List<String> authors;
        public String publisher;
        public String publishedDate;
        public String description;
    }

}
