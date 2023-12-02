import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesSimpleTaskCorrectIfTitleContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(4, "Купить продукты");

        boolean expected = true;
        boolean actual = simpleTask.matches("продукт");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTaskCorrectIfTitleNotContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(4, "Купить продукты");

        boolean expected = false;
        boolean actual = simpleTask.matches("уроки");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingCorrectIfTopicContainsQuery() {
        Meeting meeting = new Meeting(5, "Родительское собрание", "Поведение", "31 декабря");

        boolean expected = true;
        boolean actual = meeting.matches("собрание");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingCorrectIfProjectContainsQuery() {
        Meeting meeting = new Meeting(5, "Родительское собрание", "Поведение", "31 декабря");

        boolean expected = true;
        boolean actual = meeting.matches("ведение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingCorrectIfTopicAndProjectNotContainsQuery() {
        Meeting meeting = new Meeting(5, "Родительское собрание", "Поведение", "31 декабря");

        boolean expected = false;
        boolean actual = meeting.matches("абракадабра");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicCorrectIfAnySubtaskContainsQuery() {
        String[] subtasks = new String[2];
        subtasks[0] = "Сходить в магазин";
        subtasks[1] = "Почистить зубы";
        Epic epic = new Epic(6, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("зубы");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicCorrectIfSubtasksNotContainsQuery() {
        String[] subtasks = new String[2];
        subtasks[0] = "Сходить в магазин";
        subtasks[1] = "Почистить зубы";
        Epic epic = new Epic(6, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("хлеб");
        Assertions.assertEquals(expected, actual);
    }
}
