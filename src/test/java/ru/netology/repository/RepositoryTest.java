package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repo = new Repository();

    private Issue i1 = new Issue(0, "Issue 1", "Marc Philipp", 125421, new HashSet<>(Arrays.asList("Label 1", "Label 2", "Label 3")), new HashSet<>(Arrays.asList("Sam Brannen", "Saurav Jaiswal", "Juliette de Rancourt")), true);
    private Issue i2 = new Issue(1, "Issue 2", "Saurav Jaiswal", 125421, new HashSet<>(Collections.singletonList("Label 1")), new HashSet<>(Arrays.asList("Sam Brannen", "Juliette de Rancourt")), true);
    private Issue i3 = new Issue(2, "Issue 3", "Marc Philipp", 125421, new HashSet<>(Arrays.asList("Label 2", "Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), false);
    private Issue i4 = new Issue(3, "Issue 4", "Juliette de Rancourt", 125421, new HashSet<>(Arrays.asList("Label 5")), new HashSet<>(Arrays.asList(("Juliette de Rancourt"))), true);
    private Issue i5 = new Issue(4, "Issue 5", "Juliette de Rancourt", 125421, new HashSet<>(), new HashSet<>(), true);

    @BeforeEach
    void setup() {
        repo.addNewIssue(i1);
        repo.addNewIssue(i2);
        repo.addNewIssue(i3);
        repo.addNewIssue(i4);
    }

    @Test
    void addNew(){
        repo.addNewIssue(i5);
        assertEquals(Arrays.asList(i1, i2, i3, i4, i5), repo.findAllIssues());
    }

    @Test
    void addToEmpty() {
        Repository repo = new Repository();
        repo.addNewIssue(i5);
        assertEquals(Arrays.asList(i5), repo.findAllIssues());
    }
}