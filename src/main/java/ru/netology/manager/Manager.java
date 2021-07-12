package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
@NoArgsConstructor
@Data

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Issue issue) {
        repo.addNewIssue(issue);
    }

    public List<Issue> findAll() {
        return repo.findAllIssues();
    }

    private List<Issue> filterBy(Predicate<Issue> filter) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repo.findAllIssues()) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAuthor(String author) {
        return filterBy(issue -> issue.getAuthor().equalsIgnoreCase(author));
    }

    public List<Issue> filterByLabel(String label) {
        return filterBy(issue -> issue.getLabel().contains(label));
    }

    public List<Issue> filterByAssign(String assignee) {
        return filterBy(issue -> issue.getAssignee().contains(assignee));
    }

    public List<Issue> filterByDate(int date) {
        return filterBy(issue -> issue.getDate() == date);
    }

    public List<Issue> filterByStatus(boolean status) {
        return filterBy(issue -> issue.getOpened() == status);
    }

    public List<Issue> sortByNew() {
        repo.findAllIssues().sort(Comparator.comparingInt(Issue::getDate));
        return repo.findAllIssues();
    }

    public List<Issue> sortByOld() {
        repo.findAllIssues().sort((a, b) -> b.getDate() - a.getDate());
        return repo.findAllIssues();
    }


    public void openCloseByID(int id) {
        for (Issue issue : repo.findAllIssues()) {
            if (issue.getId() == id) {
                issue.setOpened(!issue.getOpened());
            }
            System.out.printf("Id %id not found\n", id);
        }
    }
}
