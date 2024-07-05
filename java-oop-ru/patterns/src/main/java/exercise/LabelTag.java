package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface parent;
    private String text;

    public TagInterface getParent() {
        return parent;
    }

    public void setParent(TagInterface parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    LabelTag(String text, TagInterface parent) {
        this.parent = parent;
        this.text = text;
    }

    @Override
    public String render() {
        return "<label>" + text + parent.render() + "</label>";
    }
}
// END
