package pl.dominisz;

public enum Genre {

    POP("pop"),
    RAP("rap"),
    AFRICAN_HEAVY_METAL("african heavy metal");

    private String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
