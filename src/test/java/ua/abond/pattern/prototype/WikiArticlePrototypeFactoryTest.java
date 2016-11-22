package ua.abond.pattern.prototype;

import org.junit.Test;

import java.util.Collections;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class WikiArticlePrototypeFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testConstructorNullArgument() {
        new WikiArticlePrototypeFactory(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyListArgument() {
        new WikiArticlePrototypeFactory(Collections.emptyList());
    }

    @Test
    public void testGetArticleByName() throws Exception {
        String name = "name";
        String content = "content";
        WikiArticle expected = new WikiArticle(name, content);
        WikiArticlePrototypeFactory wikiArticlePrototypeFactory =
                new WikiArticlePrototypeFactory(Collections.singletonList(expected));

        WikiArticle actual = wikiArticlePrototypeFactory.getArticleByName(name).orElse(null);
        assertNotNull(actual);

        assertEquals(expected, actual);
        assertFalse(expected == actual);
    }
}