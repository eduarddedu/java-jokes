package org.codecritique.javajokes.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = JokeEntity.COLLECTION_NAME)
@NoArgsConstructor
@AllArgsConstructor
@With
@Getter
@Setter
public class JokeEntity {
    public final static String COLLECTION_NAME = "jokes";

    @Id
    private String id;

    private Integer externalId;

    private String category;

    private String joke;

}
