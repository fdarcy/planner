import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchCorrect() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(4, "Купить продукты");
        Meeting meeting = new Meeting(5, "Родительское собрание", "Поведение", "31 декабря");

        String[] subtasks = new String[2];
        subtasks[0] = "Сходить в магазин";
        subtasks[1] = "Почистить зубы";
        Epic epic = new Epic(6, subtasks);

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("зубы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchCorrectIfNoOneTaskMatches() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(4, "Купить продукты");
        Meeting meeting = new Meeting(5, "Родительское собрание", "Поведение", "31 декабря");

        String[] subtasks = new String[2];
        subtasks[0] = "Сходить в магазин";
        subtasks[1] = "Почистить зубы";
        Epic epic = new Epic(6, subtasks);

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("масло");

        Assertions.assertArrayEquals(expected, actual);
    }
}
