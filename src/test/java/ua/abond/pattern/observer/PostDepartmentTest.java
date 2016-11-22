package ua.abond.pattern.observer;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostDepartmentTest {

    @Test
    public void testAdd() throws Exception {
        PostDepartment postDepartment = new PostDepartment();

        Subscriber sub1 = new Subscriber("1");
        Subscriber sub2 = new Subscriber("2");
        Subscriber sub3 = new Subscriber("3");

        postDepartment.add(sub1);
        postDepartment.add(sub2);
        postDepartment.add(sub3);

        Magazine play = new Magazine("Play");
        postDepartment.publish(play);

        assertTrue(sub1.getOwnedMagazines().contains(play));
        assertTrue(sub2.getOwnedMagazines().contains(play));
        assertTrue(sub3.getOwnedMagazines().contains(play));
    }

    @Test
    public void testPublishAfterRemove() {
        PostDepartment postDepartment = new PostDepartment();
        Subscriber sub1 = new Subscriber("1");

        postDepartment.add(sub1);

        Magazine play = new Magazine("Play");
        postDepartment.publish(play);
        postDepartment.remove(sub1);

        Magazine test = new Magazine("test");
        postDepartment.publish(test);

        assertTrue(sub1.getOwnedMagazines().contains(play));
        assertFalse(sub1.getOwnedMagazines().contains(test));
    }
}