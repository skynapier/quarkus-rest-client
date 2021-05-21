package tian.books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbDateFormat;
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

        @JsonbDateFormat("yyyy-MM-dd")
        public Date publishedDate;
        public String description;
        public List<IndustryIdentifier> industryIdentifiers;
    }

    public static class IndustryIdentifier{
        public String type;
        public String identifier;

    }

}
