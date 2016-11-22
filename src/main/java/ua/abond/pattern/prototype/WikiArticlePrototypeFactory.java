package ua.abond.pattern.prototype;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WikiArticlePrototypeFactory {
    private final List<WikiArticle> articles;

    public WikiArticlePrototypeFactory(List<WikiArticle> articles) {
        Objects.requireNonNull(articles);
        if (articles.isEmpty()) {
            throw new IllegalArgumentException("Article list is empty");
        }
        this.articles = articles;
    }

    public Optional<WikiArticle> getArticleByName(String name) {
        return articles.
                stream().
                filter(a -> a.getName().equals(name)).
                findFirst().
                map(WikiArticle::new);
    }
}
