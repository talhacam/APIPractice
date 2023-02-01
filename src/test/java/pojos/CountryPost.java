package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class CountryPost {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryPost(String name) {
        this.name = name;
    }

    public CountryPost() {
    }

    @Override
    public String toString() {
        return "CountryPost{" +
                "name='" + name + '\'' +
                '}';
    }
}
