package ua.abond.pattern.prototype;

public class WikiArticle {
    private String name;
    private String content;

    public WikiArticle() {

    }

    public WikiArticle(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public WikiArticle(WikiArticle that) {
        this.name = that.name;
        this.content = that.content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WikiArticle)) return false;

        WikiArticle article = (WikiArticle) o;

        if (getName() != null ? !getName().equals(article.getName()) : article.getName() != null) return false;
        return getContent() != null ? getContent().equals(article.getContent()) : article.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
