package com.example.applicationstarter.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "posts")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private List<CommentEntity> comments;

    @OneToOne(
            mappedBy = "post",
            cascade = ALL,
            fetch = LAZY
    )
    @ToString.Exclude
    private PostDetailEntity detail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @ToString.Exclude
    private List<TagEntity> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PostEntity that = (PostEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
    @Override
    public int hashCode(){
        return getClass().hashCode();
    }


}