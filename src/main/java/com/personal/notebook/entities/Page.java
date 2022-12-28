package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pages")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Integer pageId;
    @Column
    private Integer page;
    @ManyToOne
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;
    @OneToMany(mappedBy = "page")
    @JsonIgnore
    private List<Workout> workouts;

    public Page(Integer page, Notebook notebook, List<Workout> workouts) {
        this.page = page;
        this.notebook = notebook;
        this.workouts = workouts;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", page=" + page +
                ", notebook=" + notebook +
                '}';
    }
}
