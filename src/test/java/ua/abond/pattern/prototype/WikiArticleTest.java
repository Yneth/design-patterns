package ua.abond.pattern.prototype;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;

public class WikiArticleTest {

    @Test
    public void testCreateWikiArticle() {
        WikiArticle article = new WikiArticle();

        assertNull(article.getContent());
        assertNull(article.getName());
    }
}