package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "notebooks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notebook_id")
    private Integer notebookId;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    @OneToMany(mappedBy = "notebook")
    @JsonIgnore
    private List<Page> pages;

    public Notebook(User user, List<Page> pages) {
        this.user = user;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(notebookId, notebook.notebookId) && Objects.equals(user, notebook.user) && Objects.equals(pages, notebook.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notebookId, user, pages);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "notebookId=" + notebookId +
                ", user=" + user +
                '}';
    }
}