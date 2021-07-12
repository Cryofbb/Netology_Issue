package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    Manager manager = new Manager();
    Repository repo = new Repository();
    private Issue i1 = new Issue(0, "Issue 1", "Marc Philipp", 125421, new HashSet<>(Arrays.asList("Label 1", "Label 2", "Label 3")), new HashSet<>(Arrays.asList("Sam Brannen", "Saurav Jaiswal", "Juliette de Rancourt")), true);
    private Issue i2 = new Issue(1, "Issue 2", "Saurav Jaiswal", 125421, new HashSet<>(Collections.singletonList("Label 1")), new HashSet<>(Arrays.asList("Sam Brannen", "Juliette de Rancourt")), true);
    private Issue i3 = new Issue(2, "Issue 3", "Marc Philipp", 125421, new HashSet<>(Arrays.asList("Label 2", "Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), false);
    private Issue i4 = new Issue(3, "Issue 4", "Juliette de Rancourt", 125421, new HashSet<>(Arrays.asList("Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), true);
    private Issue i5 = new Issue(4, "Issue 5", "Juliette de Rancourt", 125421, new HashSet<>(), new HashSet<>(), true);

//    @BeforeEach
//    void setup() {
//        manager.add(i1);
//        manager.add(i2);
//        manager.add(i3);
//        manager.add(i4);
//        manager.add(i5);
//    }
//
//    @Test
//    void addToEmpty() {
//        manager.add(i2);
//        System.out.println(manager.findAll());
//    }
//
//    @Test
//    private void addToExist() {
//    }
//
//    @Test
//    private void findAll() {
//    }
//
//    @Test
//    private void findOpened() {
//    }
//
//    @Test
//    private void findClosed() {
//    }
//
//    @Test
//    private void findByAuthor() {
//    }
//
//    @Test
//    private void findByLabel() {
//    }
//
//    @Test
//    private void findByName() {
//    }
//
//    @Test
//    private void findByDate() {
//    }
//
//    @Test
//    private void findByAssignee() {
//    }
//
//    @Test
//    private void changeStatus() {
//    }
//
//    @Test
//    private void sortByNew() {
//    }
//
//    @Test
//    private void sortByOld() {
//    }
//
//
}