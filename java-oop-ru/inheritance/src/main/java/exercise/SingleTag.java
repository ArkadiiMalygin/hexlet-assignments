package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    private Map<String,String> attributes;

    public SingleTag(String name, Map<String, String> attributes) {
        super(name);
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        var res = new StringBuilder();
        res.append("<");
        res.append(tagName);
        res.append(" ");
        for(Map.Entry element : attributes.entrySet()) {
            String name = (String) element.getKey();
            String value = (String) element.getValue();
            res.append(name);
            res.append("=\"");
            res.append(value);
            res.append("\" ");
        }
        res.delete(res.length()-1,res.length());
        res.append(">");

        return res.toString();
    }
}
// END
