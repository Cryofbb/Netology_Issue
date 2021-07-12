package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.NotFoundExeption;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    private Issue i1 = new Issue(1, "Issue 1", "Marc Philipp", 2020_08_10, new HashSet<>(Arrays.asList("Label 1", "Label 2", "Label 3")), new HashSet<>(Arrays.asList("Sam Brannen", "Saurav Jaiswal", "Juliette de Rancourt")), true);
    private Issue i2 = new Issue(2, "Issue 2", "Saurav Jaiswal", 2020_09_10, new HashSet<>(Collections.singletonList("Label 1")), new HashSet<>(Arrays.asList("Sam Brannen", "Juliette de Rancourt")), true);
    private Issue i3 = new Issue(3, "Issue 3", "Marc Philipp", 2021_01_30, new HashSet<>(Arrays.asList("Label 2", "Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), false);
    private Issue i4 = new Issue(4, "Issue 4", "Juliette de Rancourt", 2019_02_24, new HashSet<>(Arrays.asList("Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), true);
    private Issue i5 = new Issue(5, "Issue 5", "Juliette de Rancourt", 2020_12_31, new HashSet<>(), new HashSet<>(), true);

    @BeforeEach
    void setup() {
        manager.add(i1);
        manager.add(i2);
        manager.add(i3);
        manager.add(i4);
    }


    @Test
    void add() {
        manager.add(i5);
        assertEquals(Arrays.asList(i1, i2, i3, i4, i5), manager.findAll());
    }

    @Test
    void findAll() {
        assertEquals(Arrays.asList(i1, i2, i3, i4), manager.findAll());
    }

    @Test
    void findOpened() {
        assertEquals(Arrays.asList(i1, i2, i4), manager.filterByStatus(true));
    }

    @Test
    void findClosed() {
        assertEquals(Arrays.asList(i3), manager.filterByStatus(false));
    }

    @Test
    void findByAuthor() {
        assertEquals(Arrays.asList(i1, i3), manager.filterByAuthor("Marc Philipp"));
    }

    @Test
    void findByLabel() {
        assertEquals(Arrays.asList(i1, i2), manager.filterByLabel("Label 1"));
    }

    @Test
    void findByAssignee() {
        assertEquals(Arrays.asList(i1), manager.filterByAssign("Saurav Jaiswal"));
    }

    @Test
    void findByDate() {
        assertEquals(Arrays.asList(i3), manager.filterByDate(2021_01_30));
    }


    @Test
    void sortByNew() {
        assertEquals(Arrays.asList(i4, i1, i2, i3), manager.sortByNew());
    }

    @Test
    void sortByOld() {
        assertEquals(Arrays.asList(i3, i2, i1, i4), manager.sortByOld());
    }

    @Test
    void checkStatus() {
        assertEquals(true, manager.checkStatus(2));
    }

    @Test
    void changeStatusToClose() {
        manager.changeStatusById(2);
        assertFalse(manager.checkStatus(2));
    }

    @Test
    void changeStatusToOpen() {
        manager.changeStatusById(3);
        assertTrue(manager.checkStatus(3));
    }

    @Test
    void checkStatusWithWrongID() {
        assertThrows(NotFoundExeption.class, () -> {
            manager.checkStatus(12);
        });
    }

//    @Test
//    void changeStatusWithWrongID() {
//        assertThrows(NotFoundExeption.class, () -> {
//            manager.changeStatusById(12);
//        });
//    }
}