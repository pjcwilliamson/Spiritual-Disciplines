package org.williamsonministry.spiritualdisciplines;

public class Training {
    private int id;
    private String name;
    private String longDesc;
    private String shortDesc;
    private String imageURL;

    public Training(int id, String name, String longDesc, String shortDesc, String imageURL) {
        this.id = id;
        this.name = name;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
