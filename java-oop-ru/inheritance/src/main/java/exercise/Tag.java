package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public abstract String toString();
}
// END
