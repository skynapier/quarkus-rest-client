package tian.books.rest.client;

import org.slf4j.Logger;
import tian.books.Book;

import static org.slf4j.LoggerFactory.getLogger;

public class BooksClientImpl implements BooksClient{


    private static final Logger LOG = getLogger(BooksClient.class);


    @Override
    public Book getGoogleEbooks(String q, String filtering, String printType, String projection, String sorting) {

        return  getGoogleEbooks(q,filtering,printType,projection,sorting);
    }
}
