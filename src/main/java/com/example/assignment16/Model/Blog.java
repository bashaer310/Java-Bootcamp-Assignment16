package com.example.assignment16.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {


    @Id
    private Integer id;

    @NotEmpty(message = "Title must not be empty")
    @Size(max = 25,message = "Title length must be less than 26")
    @Column(columnDefinition = "varchar(25) not null check(LENGTH(title)<=25)")
    private String title;

    @NotEmpty(message = "Body must not be empty")
    @Size(min = 50,message = "Body length must be more than 50")
    @Column(columnDefinition = "varchar(256) not null check(LENGTH(body)>=50)")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;
}
