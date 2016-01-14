package xyz.uabart.skazochnik.Objects;

public class Book {

    private String name;
    private int imageSrc;

    public Book(String name, int imageSrc) {
        this.name = name;
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public int getImageSrc() {
        return imageSrc;
    }

}
