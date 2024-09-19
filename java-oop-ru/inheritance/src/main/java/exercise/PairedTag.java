package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private Map<String,String> attributes;

    private String text;

    private List<Tag> smallerTags;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> tags) {
        super(name);
        this.attributes = attributes;
        this.text = text;
        this.smallerTags = tags;
    }

    @Override
    public String toString() {
        var res = new StringBuilder();
        res.append("<");
        res.append(tagName);
        res.append(" ");
        for(Map.Entry<String,String> element : attributes.entrySet()) {
            String name =  element.getKey();
            String value =  element.getValue();
            res.append(name);
            res.append("=\"");
            res.append(value);
            res.append("\" ");
        }
        res.delete(res.length()-1,res.length());
        res.append(">");

        for(Tag tag : smallerTags) {
            res.append(tag.toString());
        }

        res.append(text);

        res.append("</");
        res.append(tagName);
        res.append(">");

        return res.toString();
    }
}
// END
